package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.VehicleEntity;

import java.util.Optional;

@Repository
public interface VehicleEntityRepository extends JpaRepository<VehicleEntity, Long> {
}
