package com.pragma.microserviciousuarios.domain.usecases;

import com.pragma.microserviciousuarios.domain.exceptions.UserAlreadyExistsException;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.in.UserServicePort;
import com.pragma.microserviciousuarios.domain.ports.out.UserPersistencePort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserUseCase implements UserServicePort {
    private final UserPersistencePort userPersistencePort;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserUseCase(UserPersistencePort userPersistencePort, BCryptPasswordEncoder passwordEncoder) {
        this.userPersistencePort = userPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserModel userModel) {
        UserModel userByEmail = userPersistencePort.getUserByEmail(userModel.getEmail());
        UserModel userByIdentification = userPersistencePort.getUserByIdentification(userModel.getDocumentNumber());

        if (userByEmail != null || userByIdentification != null) {
            throw new UserAlreadyExistsException();
        }

        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userPersistencePort.saveUser(userModel);
    }


}
