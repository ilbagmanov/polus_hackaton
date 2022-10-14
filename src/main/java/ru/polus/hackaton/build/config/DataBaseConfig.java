package ru.polus.hackaton.build.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.polus.hackaton.build.model.JobEntity;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataBaseConfig {


    @Bean(value = "jobsEntityTable")
    @Scope("singleton")
    public List<JobEntity> createJobsEntityTable() {
        return new ArrayList<>();
    }
}
