package ru.polus.hackaton.build.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long executorId;

    private String name;
    private String login;
    private String password;
    private Double lon;
    private Double lat;
    private String status;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ExecutorRoles> roles;
    private String jobId;
}
