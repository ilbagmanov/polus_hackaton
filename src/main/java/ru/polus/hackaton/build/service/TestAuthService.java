package ru.polus.hackaton.build.service;

import org.springframework.stereotype.Service;
import ru.polus.hackaton.build.dto.TestAuthForm;

@Service
public class TestAuthService {

    public boolean auth(TestAuthForm form) {
        return (form.getLogin() != null &&
                form.getPassword() != null &&
                form.getLogin().equals("78005553535") &&
                form.getPassword().equals("lorem ipsum"));
    }
}
