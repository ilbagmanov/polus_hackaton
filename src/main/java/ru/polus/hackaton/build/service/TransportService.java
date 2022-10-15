package ru.polus.hackaton.build.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.polus.hackaton.build.model.Job;
import ru.polus.hackaton.build.model.ModelVehicle;
import ru.polus.hackaton.build.repository.JobRepository;
import ru.polus.hackaton.build.repository.ModelVehicleRepository;
import ru.polus.hackaton.build.repository.TypeVehicleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportService implements ru.polus.hackaton.build.service.Service {

    @Autowired
    private TypeVehicleRepository typeVehicleRepository;

    @Autowired
    private ModelVehicleRepository modelVehicleRepository;

    @Autowired
    private JobRepository jobRepository;

    public boolean algo(Job job) {

        String typeVehicle = job.getTypeVehicle();
        List<Long> listModelId = typeVehicleRepository.getAllTypeVehiclesByType(typeVehicle).get().stream().map(x -> x.getId()).collect(
                Collectors.toList());

        List<ModelVehicle> modelVehicles = new ArrayList<>();

        for (Long id : listModelId) {
            modelVehicles.add(modelVehicleRepository.getAllById(id));
        }

        List<ModelVehicle> candidateModel = new ArrayList<>();
        for (ModelVehicle modelVehicle : modelVehicles) {
            List<Job> jobList = modelVehicle.getJob();
            boolean flag = true;
            for (Job oldJob : jobList) {
                if (job.getStartDate() < oldJob.getEndDate() || job.getEndDate() > oldJob.getStartDate()) {
                    flag = false;
                }
            }
            if (flag) {
                candidateModel.add(modelVehicle);
            }
        }

        Long id = Long.valueOf(0);
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < candidateModel.size(); i++) {
            double ansI = length(candidateModel.get(i), job);
            if (ansI < ans) {
                ans = ansI;
                id = Long.valueOf(i);
            }
        }
        if (ans == Double.MAX_VALUE) {
            return false;
        }

        ModelVehicle modelVehicle = modelVehicleRepository.getAllById(id);
        List<Job> list = modelVehicle.getJob();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(jobRepository.getOne(id));
        modelVehicleRepository.save(modelVehicle);

        return false;
    }

    public Double length(ModelVehicle modelVehicle, Job job) {
        Double lat = modelVehicle.getLat();
        Double lon = modelVehicle.getLon();

        Double latJob = job.getLat();
        Double lonJob = job.getLon();

        return Math.sqrt((lat * lat - latJob * latJob) + (lon * lon - lonJob * lonJob));
    }
}
