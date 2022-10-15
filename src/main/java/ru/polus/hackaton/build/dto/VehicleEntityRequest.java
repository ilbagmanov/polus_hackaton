package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntityRequest {

    private String id;
    private String park;
    private String characteristic;
    private String model;
    private String jobId;
    private Long startDate;
    private Long endDate;
    private String executorId;

}
