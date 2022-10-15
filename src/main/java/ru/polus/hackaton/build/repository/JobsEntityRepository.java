package ru.polus.hackaton.build.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.JobEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JobsEntityRepository {

    @Autowired
    @Qualifier("jobsEntityTable")
    private List<JobEntity> jobsEntityTable;

    public Optional<JobEntity> getJobEntityById(String id) {
        return jobsEntityTable.stream().filter(x -> x.getJobId().equals(id)).findFirst();
    }

    public void createJobEntity(JobEntity entity) {
        //entity.setJobId(UUID.randomUUID().toString());
        jobsEntityTable.add(entity);
    }

    public void deleteJobEntity(String jobEntityId) {
        jobsEntityTable.remove(jobsEntityTable.indexOf(jobEntityId));
    }

    private void update(JobEntity entity) {
        //JobEntity jobEntity = getJobEntityById(entity.getJobId()).orElseThrow(IllegalArgumentException::new);
        JobEntity jobEntity = new JobEntity();
        jobEntity.setEndDate(entity.getEndDate());
        jobEntity.setStartDate(entity.getStartDate());
        //jobEntity.setCustomerId(entity.getCustomerId());
        jobEntity.setLat(entity.getLat());
        jobEntity.setLon(entity.getLon());
        jobEntity.setStatus(entity.getStatus());
        //jobEntity.setRequiredVehiclesRoles(entity.getRequiredVehiclesRoles());
    }

    public List<JobEntity> getJobsEntityTable() {
        return jobsEntityTable;
    }

    public List<JobEntity> getJobsEntityByCustomerId(String id) {
        return null;
        //return jobsEntityTable.stream().filter(x -> x.getCustomerId().equals(id)).collect(Collectors.toList());
    }
}
