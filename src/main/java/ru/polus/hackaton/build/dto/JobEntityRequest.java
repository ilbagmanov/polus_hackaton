package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobEntityRequest {

    private Long id;

    @NotNull
    private Long startDate;

    @NotNull
    private Long endDate;

    @NotNull
    private String title;

    private String status;

    @NotNull
    private Double lon;

    @NotNull
    private Double lat;

    @NotNull
    private Long customerId;

    @NotNull
    private Map<String, String> requiredVehicle;

    private Long executorId;
}
