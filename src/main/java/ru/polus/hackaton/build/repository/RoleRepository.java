package ru.polus.hackaton.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polus.hackaton.build.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
