package com.pragma.microserviciousuarios.commons.configuration.beans;

import com.pragma.microserviciousuarios.domain.ports.in.AuthenticationServicePort;
import com.pragma.microserviciousuarios.domain.ports.in.UserServicePort;
import com.pragma.microserviciousuarios.domain.ports.out.UserPersistencePort;
import com.pragma.microserviciousuarios.domain.usecases.AuthenticationUseCase;
import com.pragma.microserviciousuarios.domain.usecases.UserUseCase;
import com.pragma.microserviciousuarios.infrastructure.adapter.persistence.UserPersistenceAdapter;
import com.pragma.microserviciousuarios.infrastructure.mappers.UserEntityMapper;
import com.pragma.microserviciousuarios.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    // User
    @Bean
    public UserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), passwordEncoder());
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Authentication
    @Bean
    public AuthenticationServicePort authenticationServicePort() {
        return new AuthenticationUseCase(userPersistencePort(), passwordEncoder());
    }
}
