package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.polus.hackaton.build.model.JobEntity;
import ru.polus.hackaton.build.repository.JobsEntityRepository;
import ru.polus.hackaton.build.util.ResponseStatus;

import java.util.Map;

@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    private JobsEntityRepository entityRepository;

    @PostMapping(value = "/job")
    public ResponseEntity<Map<String, String>> addOrder(@RequestBody JobEntity entity){
        entityRepository.createJobEntity(entity);
        return ResponseStatus.doSuccess();
    }

    @PutMapping(value = "/job")
    public ResponseEntity<?> updateOrder(@RequestBody JobEntity entity){
        entityRepository.createJobEntity(entity);
        return ResponseStatus.doSuccess();
    }

    @DeleteMapping(value = "/job")
    public ResponseEntity<?> deleteOrder(@RequestBody String id){
        entityRepository.deleteJobEntity(id);
        return ResponseStatus.doSuccess();
    }

    @GetMapping(value = "/jobs")
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok(entityRepository.getJobsEntityTable());
    }

    @GetMapping(value = "/jobs/{customerId}")
    public ResponseEntity<?> getAllCustomerOrders(@PathVariable String customerId){
        return ResponseEntity.ok(entityRepository.getJobsEntityByCustomerId(customerId));
    }

}
