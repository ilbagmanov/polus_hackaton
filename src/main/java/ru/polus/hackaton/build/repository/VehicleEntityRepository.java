package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.polus.hackaton.build.model.VehicleEntity;

import java.util.List;

public interface VehicleEntityRepository extends JpaRepository<VehicleEntity, Long> {

    List<VehicleEntity> getAllByCharacteristic(String characteristic);
    List<VehicleEntity> getAllByCharacteristicAndModel(String characteristic, String model);
}
