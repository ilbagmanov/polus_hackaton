package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.polus.hackaton.build.model.Account;
import ru.polus.hackaton.build.model.Customer;
import ru.polus.hackaton.build.repository.CustomerRepository;
import ru.polus.hackaton.build.util.ResponseStatus;

import java.util.Collections;

@RestController
public class TestController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/test")
    public ResponseEntity<?> getTest() {
        return ResponseEntity.ok(Collections.singletonMap("Status","success"));
    }

    @GetMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(){
        Customer customer = new Customer(null, "Ildar");
        customer.setLogin("customer0");
        customer.setPassword("0000");
        customer.setType("customer");
        customerRepository.save(customer);
        return ResponseStatus.doSuccess();
    }
}
