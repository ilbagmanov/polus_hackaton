package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobEntityRequest {

    private Long jobId;
    private String title;
    private Long startDate;
    private Long endDate;
    private String status;
    private Double lon;
    private Double lat;
    private Long customerId;
    //private RequiredVehicle requiredVehicle;
    private Long executorId;
}
