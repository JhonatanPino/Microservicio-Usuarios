package com.pragma.microserviciousuarios.domain.ports.out;

import com.pragma.microserviciousuarios.domain.models.UserModel;

public interface UserPersistencePort {

    void saveUser(UserModel userModel);

    UserModel getUserByEmail(String userEmail);
}
