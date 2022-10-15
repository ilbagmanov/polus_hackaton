package ru.polus.hackaton.build.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.polus.hackaton.build.model.JobEntity;
import ru.polus.hackaton.build.model.RequiredVehicle;
import ru.polus.hackaton.build.repository.CustomerEntityRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobEntityRequest {

    @Autowired
    private CustomerEntityRepository customerEntityRepository;

    private Long jobId;
    private String title;
    private Long startDate;
    private Long endDate;
    private String status;
    private Double lon;
    private Double lat;
    private Long customerId;
    private RequiredVehicle requiredVehicle;
    private Long executorId;


    public JobEntity mapper(){
        return JobEntity.builder()
                .jobId(this.jobId)
                .title(this.title)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .status(this.status)
                .lon(this.lon)
                .lat(this.lat)
                .customer(customerEntityRepository.getReferenceById(this.customerId))
                .requiredVehicle(this.requiredVehicle)
                .executorId(this.executorId)
                .build();
    }
}
