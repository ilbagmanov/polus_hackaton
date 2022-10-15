package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.polus.hackaton.build.dto.JobEntityRequest;
import ru.polus.hackaton.build.model.Customer;
import ru.polus.hackaton.build.model.Job;
import ru.polus.hackaton.build.model.TypeVehicle;
import ru.polus.hackaton.build.repository.CustomerRepository;
import ru.polus.hackaton.build.repository.ExecutorRepository;
import ru.polus.hackaton.build.repository.JobRepository;
import ru.polus.hackaton.build.repository.TypeVehicleRepository;
import ru.polus.hackaton.build.util.ResponseStatus;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TypeVehicleRepository typeVehicleRepository;
    @Autowired
    private ExecutorRepository executorRepository;

    @PostMapping(value = "/job")
    public ResponseEntity<Map<String, String>> addJob(@RequestBody @Valid JobEntityRequest body) {
        try {
            Job job = mapToMandatoryJob(body);
            jobRepository.save(job);
        } catch (ValidationException e) {
            return ResponseEntity.status(401).body(Collections.singletonMap("Error", e.getMessage()));
        }
        return ResponseStatus.doSuccess();
    }

    @PutMapping(value = "/job")
    public ResponseEntity<?> updateJob(@RequestBody @Valid JobEntityRequest body) {
        try {
            Job job = mapToMandatoryJob(body);
            job.setId(body.getId());
            if (body.getExecutorId() != null)
                job.setExecutor(executorRepository.getById(body.getExecutorId()));
            jobRepository.save(job);
        } catch (ValidationException e) {
            return ResponseEntity.status(401).body(Collections.singletonMap("Error", e.getMessage()));
        }
        return ResponseStatus.doSuccess();
    }

    public Job mapToMandatoryJob(JobEntityRequest body) {
        Job job = Job.builder()
                .startDate(body.getStartDate())
                .endDate(body.getEndDate())
                .lat(body.getLat())
                .lon(body.getLon())
                .title(body.getTitle())
                .status(body.getStatus())
                .build();

        Optional<Customer> customer = customerRepository.findById(body.getCustomerId());
        if (customer.isPresent())
            job.setCustomer(customer.get());
        else {
            throw new ValidationException("CustomerId is not valid");
        }

        String type = body.getRequiredVehicle().getOrDefault("type", null);
        String model = body.getRequiredVehicle().getOrDefault("model", null);
        if (type == null && model == null)
            throw new ValidationException("Type and model of vehicle is null");
        Optional<List<TypeVehicle>> typeVehicle;
        if (type != null && model != null)
         typeVehicle = typeVehicleRepository.getAllTypeVehiclesByTypeAndModel(type, model);
        else if (type == null)
            typeVehicle = typeVehicleRepository.getAllTypeVehiclesByModel(model);
        else
            typeVehicle = typeVehicleRepository.getAllTypeVehiclesByType(type);
        if (!typeVehicle.isPresent() || typeVehicle.get().size() == 0)
            throw new ValidationException("Model or type is not valid");

        job.setTypeVehicle(typeVehicle.get().get(0).getType());
        if (model != null)
            job.setModelVehicle(typeVehicle.get().get(0).getModelVehicle().getModel());
        return job;
    }

    @DeleteMapping(value = "/job/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable Long jobId) {
        jobRepository.deleteById(jobId);
        return ResponseStatus.doSuccess();
    }

    @GetMapping(value = "/jobs")
    public ResponseEntity<?> getAllJobs() {
        return ResponseEntity.ok(jobRepository.findAll());
    }

    @GetMapping(value = "/jobs/{customerId}")
    public ResponseEntity<?> getAllCustomerOrders(@PathVariable Long customerId) {
        Optional<List<Job>> list = jobRepository.getAllByCustomer_Id(customerId);
        if (list.isPresent())
            return ResponseEntity.ok(list.get());
        else
            return ResponseStatus.doFailed();
    }
}
