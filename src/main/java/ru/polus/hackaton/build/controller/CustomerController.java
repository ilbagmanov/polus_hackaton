package ru.polus.hackaton.build.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("customer")
@RestController
@CrossOrigin
public class CustomerController {

    /*@Autowired
    private JobEntityRepository jobEntityRepository;
    @Autowired
    private CustomerEntityRepository customerEntityRepository;
    @Autowired
    private RequiredVehicleRepository requiredVehicleRepository;

    @PostMapping(value = "/job")
    public ResponseEntity<Map<String, String>> addOrder(@RequestBody JobEntityRequest entity){
        JobEntity jb = entity.mapper();
        jb.setCustomer(customerEntityRepository.getReferenceById(entity.getCustomerId()));
        jb.setRequiredVehicle(requiredVehicleRepository.getRequiredVehicleByCharacteristicAndModel(entity.getRequiredVehicle().getCharacteristic(), entity.getRequiredVehicle().getModel()));
        jobEntityRepository.save(jb);
        return ResponseStatus.doSuccess();
    }

    @PutMapping(value = "/job")
    public ResponseEntity<?> updateOrder(@RequestBody JobEntityRequest entity){
        JobEntity jb = entity.mapper();
        jb.setCustomer(customerEntityRepository.getReferenceById(entity.getCustomerId()));
        jb.setRequiredVehicle(requiredVehicleRepository.getRequiredVehicleByCharacteristicAndModel(entity.getRequiredVehicle().getCharacteristic(), entity.getRequiredVehicle().getModel()));
        jobEntityRepository.save(jb);
        return ResponseStatus.doSuccess();
    }

    @DeleteMapping(value = "/job")
    public ResponseEntity<?> deleteOrder(@RequestBody Long id){
        jobEntityRepository.deleteById(id);
        return ResponseStatus.doSuccess();
    }

    @GetMapping(value = "/jobs")
    public ResponseEntity<?> getAllOrders(){
        List<JobEntity> all = jobEntityRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/jobs/{customerId}")
    public ResponseEntity<?> getAllCustomerOrders(@PathVariable Long customerId){
        return ResponseEntity.ok(jobEntityRepository.getAllByCustomerId(customerId));
    }
    */
}
