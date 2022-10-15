package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.polus.hackaton.build.model.JobEntity;

import java.util.List;

public interface JobEntityRepository extends JpaRepository<JobEntity, Long> {

    @Query(nativeQuery = true, value = "select * from job_entity " +
            "where customer_id = :customerId")
    List<JobEntity> getAllByCustomerId(Long customerId);
}
