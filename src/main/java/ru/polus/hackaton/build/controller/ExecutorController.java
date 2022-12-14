package ru.polus.hackaton.build.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.polus.hackaton.build.model.Executor;
import ru.polus.hackaton.build.model.Job;
import ru.polus.hackaton.build.repository.ExecutorRepository;
import ru.polus.hackaton.build.repository.JobRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("executor")
@RestController
public class ExecutorController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("jobs/{executorId}")
    public ResponseEntity<?> getJobsByExecutorId(@PathVariable Long executorId) {
        return ResponseEntity.ok(jobRepository.getJobsByExecutorId(executorId));
    }

    @GetMapping("jobs")
    public ResponseEntity<?> getJobsWithExecutors() {
        Optional<List<Job>> jobsWithExecutor = jobRepository.getJobsWithExecutor();
        return ResponseEntity.ok(jobsWithExecutor);
    }


}
