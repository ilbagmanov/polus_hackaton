package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutorEntityRequest {

    private String executorId;
    private String name;
    private String login;
    private String password;
    private Double lon;
    private Double lat;
    private String status;
    private List<String> roles;
    private String jobId;
}
