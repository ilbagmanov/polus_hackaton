package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.polus.hackaton.build.model.RequiredVehicle;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobEntityRequest {

    private String jobId;
    private String title;
    private Long startDate;
    private Long endDate;
    private String status;
    private Double lon;
    private Double lat;
    private String customerId;
    private RequiredVehicle requiredVehicle;
    private String executorId;
}
