package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.polus.hackaton.build.dto.TestAuthForm;
import ru.polus.hackaton.build.service.TestAuthService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
public class TestController {

    private static final String USER_TOKEN = "146d48e4-2ed0-40db-88dc-56cfcc98e263";

    @Autowired
    private TestAuthService authService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> getTest() {
        return ResponseEntity.ok(Collections.singletonMap("Status","success"));
    }

    @PostMapping(value = "/api/signIn")
    public ResponseEntity<Map<String, String>> signIn(@Valid @RequestBody TestAuthForm form) {
        return authService.auth(form) ?
                ResponseEntity.ok(Collections.singletonMap("executorId", USER_TOKEN))
                : ResponseEntity.status(403).body(null);

    }

}
