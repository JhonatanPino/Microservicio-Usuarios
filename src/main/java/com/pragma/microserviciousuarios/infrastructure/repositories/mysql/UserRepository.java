package com.pragma.microserviciousuarios.infrastructure.repositories.mysql;

import com.pragma.microserviciousuarios.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByDocumentNumber(String identification);
}
