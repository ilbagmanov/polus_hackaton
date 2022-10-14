package ru.polus.hackaton.build.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobEntity {

    private String jobId;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;
    @NotNull
    private String status;
    @NotNull
    private Double lon;
    @NotNull
    private Double lat;
    @NotNull
    private String CustomerId;
    @NotNull
    private Map<String, Integer> requiredVehiclesRoles;
}
