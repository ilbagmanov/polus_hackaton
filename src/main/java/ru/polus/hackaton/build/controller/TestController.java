package ru.polus.hackaton.build.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public ResponseEntity<?> getTest() {
        return ResponseEntity.ok(Collections.singletonMap("Status","success"));
    }

}
