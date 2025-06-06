package com.pragma.microserviciousuarios.domain.usecases;

import com.pragma.microserviciousuarios.application.dto.request.AuthenticationRequest;
import com.pragma.microserviciousuarios.domain.exceptions.InvalidCredentialsException;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.in.AuthenticationServicePort;
import com.pragma.microserviciousuarios.domain.ports.out.UserPersistencePort;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

public class AuthenticationUseCase implements AuthenticationServicePort {
    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationUseCase(UserPersistencePort userPersistencePort, PasswordEncoder passwordEncoder) {
        this.userPersistencePort = userPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserModel authenticate(AuthenticationRequest authenticationRequest) {
        return validateCredentials(authenticationRequest);
    }

    private UserModel validateCredentials(AuthenticationRequest authenticationRequest) {
        Optional<UserModel> optionalUser = Optional.ofNullable(userPersistencePort.getUserByEmail(authenticationRequest.email()));
        UserModel user = optionalUser.orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(authenticationRequest.password(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        return user;
    }
}
