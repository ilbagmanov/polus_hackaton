package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.polus.hackaton.build.model.ExecutorEntity;

public interface ExecutorEntityRepository extends JpaRepository<ExecutorEntity, Long> {
}
