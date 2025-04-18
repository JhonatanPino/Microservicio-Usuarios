package com.pragma.microserviciousuarios.infrastructure.repositories.mysql;

import com.pragma.microserviciousuarios.infrastructure.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    // Optional<RoleEntity> findById(Long id);
    // Optional<RoleEntity> findByName(String name);
    // Optional<RoleEntity> findByDescription(String description);
}
