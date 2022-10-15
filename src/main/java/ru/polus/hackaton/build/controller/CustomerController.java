package ru.polus.hackaton.build.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.polus.hackaton.build.dto.DtoJob;
import ru.polus.hackaton.build.dto.JobEntityRequest;
import ru.polus.hackaton.build.model.Job;
import ru.polus.hackaton.build.model.TypeVehicle;
import ru.polus.hackaton.build.repository.CustomerRepository;
import ru.polus.hackaton.build.repository.ExecutorRepository;
import ru.polus.hackaton.build.repository.JobRepository;
import ru.polus.hackaton.build.repository.TypeVehicleRepository;
import ru.polus.hackaton.build.util.ResponseStatus;

import javax.validation.Valid;
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
    public ResponseEntity<Map<String, String>> addJob(@RequestBody @Valid JobEntityRequest body){
        Job job = mapToMandatoryJob(body);
        jobRepository.save(job);
        return ResponseStatus.doSuccess();
    }

    @PutMapping(value = "/job")
    public ResponseEntity<?> updateJob(@RequestBody @Valid JobEntityRequest body){
        Job job = mapToMandatoryJob(body);
        job.setId(body.getId());
        if (body.getExecutorId() != null)
            job.setExecutor(executorRepository.getById(body.getCustomerId()));
        jobRepository.save(job);
        return ResponseStatus.doSuccess();
    }

    public Job mapToMandatoryJob(JobEntityRequest body) {
        Job job = Job.builder()
                .startDate(body.getStartDate())
                .endDate(body.getEndDate())
                .lat(body.getLat())
                .lon(body.getLon())
                .customer(customerRepository.getById(body.getCustomerId()))
                .executor(null)
                .title(body.getTitle())
                .status(body.getStatus())
                .build();
        String type = body.getRequiredVehicle().getOrDefault("type", "ANY");
        String model = body.getRequiredVehicle().getOrDefault("model", "ANY");
        Optional<List<TypeVehicle>> typeVehicle = typeVehicleRepository.getAllTypeVehicles(type, model);
        typeVehicle.ifPresent(typeVehicles -> job.setTypeVehicle(typeVehicles.get(0)));
        return job;
    }

    @DeleteMapping(value = "/job/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable Long jobId){
        jobRepository.deleteById(jobId);
        return ResponseStatus.doSuccess();
    }

    @GetMapping(value = "/jobs")
    public ResponseEntity<?> getAllJobs(){
        return ResponseEntity.ok(jobRepository.findAll());
    }

    @GetMapping(value = "/jobs/{customerId}")
    public ResponseEntity<?> getAllCustomerOrders(@PathVariable Long customerId){
        Optional<List<Job>> list = jobRepository.getAllByCustomer_Id(customerId);
        if (list.isPresent())
            return ResponseEntity.ok(list.get());
        else
            return ResponseStatus.doFailed();
    }
}
