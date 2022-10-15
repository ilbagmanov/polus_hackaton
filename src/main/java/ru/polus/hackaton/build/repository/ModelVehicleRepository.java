package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelVehicleRepository extends JpaRepository<ModelVehicleRepository, Long> {
}
