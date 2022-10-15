package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.polus.hackaton.build.model.VehicleEntity;

import java.util.Optional;

public interface VehicleEntityRepository extends JpaRepository<VehicleEntity, Long> {
}
