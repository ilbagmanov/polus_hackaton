package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.polus.hackaton.build.model.CustomerEntity;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long> {
}
