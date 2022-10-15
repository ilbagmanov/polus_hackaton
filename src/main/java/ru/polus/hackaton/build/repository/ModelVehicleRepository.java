package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.ModelVehicle;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelVehicleRepository extends JpaRepository<ModelVehicle, Long> {

    Optional<ModelVehicle> getModelVehicleByModel(String model);

    List<ModelVehicle> getAllByModel(String model);

    ModelVehicle getAllById(Long id);
}
