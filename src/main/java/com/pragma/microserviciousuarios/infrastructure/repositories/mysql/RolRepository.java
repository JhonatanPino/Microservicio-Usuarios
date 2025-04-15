package com.pragma.microserviciousuarios.infrastructure.repositories.mysql;

import com.pragma.microserviciousuarios.infrastructure.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolEntity, Long> {
    // Optional<RolEntity> findById(Long id);
    // Optional<RolEntity> findByName(String name);
    // Optional<RolEntity> findByDescription(String description);
}
