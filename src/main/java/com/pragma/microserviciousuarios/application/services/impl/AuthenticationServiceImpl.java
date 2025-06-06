package com.pragma.microserviciousuarios.application.services.impl;

import com.pragma.microserviciousuarios.application.dto.request.AuthenticationRequest;
import com.pragma.microserviciousuarios.application.dto.response.AuthenticationResponse;
import com.pragma.microserviciousuarios.application.services.AuthenticationService;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.in.AuthenticationServicePort;
import com.pragma.microserviciousuarios.domain.ports.out.AuthenticationPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationServicePort authenticationServicePort;
    private final AuthenticationPersistencePort authenticationPersistencePort;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UserModel user = authenticationServicePort.authenticate(request);

        String token = authenticationPersistencePort.generateToken(user);

        return new AuthenticationResponse(token);
    }

}
