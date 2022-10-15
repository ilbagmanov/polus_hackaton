package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.polus.hackaton.build.model.ModelVehicle;
import ru.polus.hackaton.build.repository.ModelVehicleRepository;

import java.util.List;

@RequestMapping("vehicles")
@RestController
@CrossOrigin
public class VehicleController {

    @Autowired
    public ModelVehicleRepository modelVehicleRepository;

    @GetMapping(value = "/{type}")
    public ResponseEntity<List<ModelVehicle>> addOrder(@PathVariable String type) {
        return ResponseEntity.ok(modelVehicleRepository.getAllByModel(type));
    }
}
