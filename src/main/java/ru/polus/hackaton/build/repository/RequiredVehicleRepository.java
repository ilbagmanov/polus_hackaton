package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.RequiredVehicle;

@Repository
public interface RequiredVehicleRepository extends JpaRepository<RequiredVehicle, Long> {

    RequiredVehicle getRequiredVehicleByCharacteristicAndModel(String characteristic, String model);
}
