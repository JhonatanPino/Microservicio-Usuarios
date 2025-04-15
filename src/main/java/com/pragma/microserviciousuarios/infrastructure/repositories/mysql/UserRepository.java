package com.pragma.microserviciousuarios.infrastructure.repositories.mysql;

import com.pragma.microserviciousuarios.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //UserEntity findByEmail(String email);

    //UserEntity findByDocumentNumber(String documentNumber);

    //UserEntity findByPhone(String phone);

    //UserEntity findByIdAndRolEntityId(Long id, Long rolId);
}
