package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInForm {

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String type;
}
