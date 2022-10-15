package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.polus.hackaton.build.model.Account;
import ru.polus.hackaton.build.model.Customer;
import ru.polus.hackaton.build.model.ModelVehicle;
import ru.polus.hackaton.build.model.TypeVehicle;
import ru.polus.hackaton.build.repository.CustomerRepository;
import ru.polus.hackaton.build.repository.ModelVehicleRepository;
import ru.polus.hackaton.build.repository.TypeVehicleRepository;
import ru.polus.hackaton.build.util.ResponseStatus;

import java.io.File;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

@RestController
public class TestController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TypeVehicleRepository typeVehicleRepository;

    @Autowired
    private ModelVehicleRepository modelVehicleRepository;

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

    @GetMapping("/updateVehicles")
    public ResponseEntity<?> updateVehicles() {
        try {
            Scanner sc = new Scanner(new File("vehicleDB.csv"));
            while (sc.hasNext()) {
                String[] inp = sc.nextLine().split(",");
                String place = inp[0]; //IGNORED
                String type = inp[1];
                String model = inp[2];
                String vehicleNumber = inp[3];
                Optional<ModelVehicle> modelVehicle = modelVehicleRepository.getModelVehicleByModel(model);
                ModelVehicle modelVehicleObject = modelVehicle.orElseGet(() -> modelVehicleRepository.save(new ModelVehicle(null, model)));

                TypeVehicle vehicle = TypeVehicle.builder()
                        .vehicleNumber(vehicleNumber)
                        .type(type)
                        .modelVehicle(modelVehicleObject)
                        .build();
                typeVehicleRepository.save(vehicle);
            }
        } catch (Exception e) {
            return ResponseEntity.status(501).build();
        }
        return ResponseStatus.doSuccess();
    }
}
