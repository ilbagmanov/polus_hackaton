package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntityRequest {

    private String customerId;
    private String name;
    private String login;
    private String password;
    private List<String> jobs;
}
