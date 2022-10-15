package ru.polus.hackaton.build.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {

    @Id
    private Long jobId;

    private Long startDate;
    private Long endDate;
    private String status;
    private Double lon;
    private Double lat;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = true)
    private CustomerEntity customer;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "required_vehicle_id", nullable = true)
    private RequiredVehicle requiredVehicle;
    private String executorId;
}
