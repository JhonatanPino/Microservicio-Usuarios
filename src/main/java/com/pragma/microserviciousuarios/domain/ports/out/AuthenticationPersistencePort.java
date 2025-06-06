package com.pragma.microserviciousuarios.domain.ports.out;

import com.pragma.microserviciousuarios.domain.models.UserModel;

public interface AuthenticationPersistencePort {

    String generateToken(UserModel user);

}

