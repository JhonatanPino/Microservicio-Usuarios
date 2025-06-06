package com.pragma.microserviciousuarios.application.services;

import com.pragma.microserviciousuarios.application.dto.request.AuthenticationRequest;
import com.pragma.microserviciousuarios.application.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
