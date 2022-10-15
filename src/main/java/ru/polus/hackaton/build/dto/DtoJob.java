package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.polus.hackaton.build.model.Customer;
import ru.polus.hackaton.build.model.Executor;
import ru.polus.hackaton.build.model.Job;
import ru.polus.hackaton.build.model.TypeVehicle;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoJob {

    private Long id;
    private String title;
    private Long startDate;
    private Long endDate;
    private Double lon;
    private Double lat;
    private String status;
    private Long customerId;
    private Long executorId;
    private String typeVehicle;
    private String modelVehicle;
    private String numberVehicle;

    public static DtoJob from(Job course) {
        DtoJob build = DtoJob.builder()
                .id(course.getId())
                .title(course.getTitle())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .lon(course.getLon())
                .lat(course.getLat())
                .status(course.getStatus())
                .customerId(course.getCustomer().getId())
                .typeVehicle(course.getTypeVehicle())
                .modelVehicle(course.getModelVehicle())
                .numberVehicle(course.getNumberVehicle())
                .build();
        if (course.getExecutor() != null)
            build.setExecutorId(course.getExecutor().getId());
        return build;
    }

    public static List<DtoJob> from(List<Job> courses) {
        return courses.stream().map(DtoJob::from).collect(Collectors.toList());
    }
}
