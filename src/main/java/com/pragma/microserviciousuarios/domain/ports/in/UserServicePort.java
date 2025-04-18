package com.pragma.microserviciousuarios.domain.ports.in;

import com.pragma.microserviciousuarios.domain.models.UserModel;

public interface UserServicePort {

    void saveUser (UserModel userModel);
}
