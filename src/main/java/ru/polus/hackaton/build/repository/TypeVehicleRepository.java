package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.TypeVehicle;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeVehicleRepository extends JpaRepository<TypeVehicle, Long> {

    @Query("SELECT tv FROM TypeVehicle tv WHERE tv.type = :type AND tv.modelVehicle.model = :model")
    Optional<List<TypeVehicle>> getAllTypeVehiclesByTypeAndModel(
            @Param("type") String type,
            @Param("model") String model);

    @Query("SELECT tv FROM TypeVehicle tv WHERE tv.type = :type")
    Optional<List<TypeVehicle>> getAllTypeVehiclesByType(
            @Param("type") String type);
    @Query("SELECT tv FROM TypeVehicle tv WHERE tv.modelVehicle.model = :model")
    Optional<List<TypeVehicle>> getAllTypeVehiclesByModel(
            @Param("model") String model);
}
