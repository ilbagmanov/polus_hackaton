package ru.polus.hackaton.build.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String executorId;

    private String login;
    private String password;
    private Double lon;
    private Double lat;
    //TODO - тут какая-то ерунда с ролями
    private String jobId;
}
