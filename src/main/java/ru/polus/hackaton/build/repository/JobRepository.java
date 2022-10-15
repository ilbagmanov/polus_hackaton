package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.Customer;
import ru.polus.hackaton.build.model.Job;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<List<Job>> getAllByCustomer_Id(Long customerId);

    @Query("SELECT job FROM Job job WHERE job.executor.id = :executorId")
    Optional<List<Job>> getJobsByExecutorId(@Param("executorId") Long executorId);
}
