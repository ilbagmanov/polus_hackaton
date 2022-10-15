package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.polus.hackaton.build.dto.SignInForm;
import ru.polus.hackaton.build.model.Account;
import ru.polus.hackaton.build.repository.AccountRepository;
import ru.polus.hackaton.build.util.ResponseStatus;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody @Valid SignInForm signInForm) {
        Optional<Account> account = accountRepository.getAccountByLoginAndAndPasswordAndAndType(signInForm.getLogin(), signInForm.getPassword(), signInForm.getType());
        if(account.isPresent()) {
            return ResponseEntity.ok(Collections.singletonMap("id", account.get().getId()));
        } else
            return ResponseStatus.doFailed();
    }
}
