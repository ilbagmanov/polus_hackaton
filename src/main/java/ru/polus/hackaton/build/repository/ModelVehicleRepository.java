package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.ModelVehicle;

@Repository
public interface ModelVehicleRepository extends JpaRepository<ModelVehicle, Long> {
}
