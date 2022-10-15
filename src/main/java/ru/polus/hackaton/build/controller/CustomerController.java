package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.polus.hackaton.build.dto.JobEntityRequest;
import ru.polus.hackaton.build.repository.JobEntityRepository;
import ru.polus.hackaton.build.util.ResponseStatus;

import java.util.Map;

@RequestMapping("customer")
@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private JobEntityRepository jobEntityRepository;

    @PostMapping(value = "/job")
    public ResponseEntity<Map<String, String>> addOrder(@RequestBody JobEntityRequest entity){
        jobEntityRepository.save(entity.mapper());
        return ResponseStatus.doSuccess();
    }

    @PutMapping(value = "/job")
    public ResponseEntity<?> updateOrder(@RequestBody JobEntityRequest entity){
        jobEntityRepository.save(entity.mapper());
        return ResponseStatus.doSuccess();
    }

    @DeleteMapping(value = "/job")
    public ResponseEntity<?> deleteOrder(@RequestBody Long id){
        jobEntityRepository.deleteById(id);
        return ResponseStatus.doSuccess();
    }

    @GetMapping(value = "/jobs")
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok(jobEntityRepository.findAll());
    }

    @GetMapping(value = "/jobs/{customerId}")
    public ResponseEntity<?> getAllCustomerOrders(@PathVariable Long customerId){
        return ResponseEntity.ok(jobEntityRepository.getAllByCustomerId(customerId));
    }

}
