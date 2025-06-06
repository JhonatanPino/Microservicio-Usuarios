package com.pragma.microserviciousuarios.domain.ports.in;

import com.pragma.microserviciousuarios.application.dto.request.AuthenticationRequest;
import com.pragma.microserviciousuarios.domain.models.UserModel;

public interface AuthenticationServicePort {

    UserModel authenticate(AuthenticationRequest authenticationRequest);

}
