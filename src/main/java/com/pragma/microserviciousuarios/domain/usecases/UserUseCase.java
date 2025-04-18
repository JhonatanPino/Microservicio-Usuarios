package com.pragma.microserviciousuarios.domain.usecases;

import com.pragma.microserviciousuarios.domain.exceptions.UserAlreadyExistsException;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.in.UserServicePort;
import com.pragma.microserviciousuarios.domain.ports.out.UserPersistencePort;

public class UserUseCase implements UserServicePort {
    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(UserModel userModel) {
        UserModel user = userPersistencePort.getUserByEmail(userModel.getEmail());

        if (user != null) {
            throw new UserAlreadyExistsException();
        }
        userPersistencePort.saveUser(userModel);
    }


}
