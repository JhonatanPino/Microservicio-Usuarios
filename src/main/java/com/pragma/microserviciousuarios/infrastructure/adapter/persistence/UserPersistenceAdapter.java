package com.pragma.microserviciousuarios.infrastructure.adapter.persistence;

import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.out.UserPersistencePort;
import com.pragma.microserviciousuarios.infrastructure.mappers.UserEntityMapper;
import com.pragma.microserviciousuarios.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void saveUser(UserModel userModel) {
        userRepository.save(userEntityMapper.modelToEntity(userModel));
    }

    @Override
    public UserModel getUserByEmail(String userEmail) {
        return userEntityMapper.entityToModel(userRepository.findByEmail(userEmail).orElse(null));
    }

    @Override
    public UserModel getUserByIdentification(String identification) {
        return userEntityMapper.entityToModel(userRepository.findByDocumentNumber(identification).orElse(null));
    }
}
