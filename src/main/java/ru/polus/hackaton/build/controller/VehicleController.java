package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.polus.hackaton.build.model.VehicleEntity;
import ru.polus.hackaton.build.repository.VehicleEntityRepository;

import java.util.List;

@RequestMapping("vehicles")
@RestController
@CrossOrigin
public class VehicleController {

    @Autowired
    public VehicleEntityRepository vehicleEntityRepository;

    @GetMapping(value = "/{type}")
    public ResponseEntity<List<VehicleEntity>> addOrder(@PathVariable String type) {
        return ResponseEntity.ok(vehicleEntityRepository.getAllByCharacteristic(type));
    }

    @GetMapping(value = "/type={type}/{model}")
    public ResponseEntity<List<VehicleEntity>> addOrder(@PathVariable String type, @PathVariable String model) {
        return ResponseEntity.ok(vehicleEntityRepository.getAllByCharacteristicAndModel(type, model));
    }
}
