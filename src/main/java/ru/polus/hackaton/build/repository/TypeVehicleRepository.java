package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.TypeVehicle;

import java.util.Optional;

@Repository
public interface TypeVehicleRepository extends JpaRepository<TypeVehicle, Long> {

    Optional<TypeVehicle> getTypeVehicleByTypeAndModelVehicle_Model(String type, String model);
}
