package ru.polus.hackaton.build.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String jobId;

    private Long startDate;
    private Long endDate;
    private String status;
    private Double lon;
    private Double lat;
    @ManyToOne
    @JoinColumn(name="customerId", nullable=false)
    private CustomerEntity customerId;
    //TODO private Map<String, Integer> requiredVehicle;
    private String executorId;
}