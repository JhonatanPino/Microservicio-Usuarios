package com.pragma.microserviciousuarios.infrastructure.adapter.persistence;

import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.out.AuthenticationPersistencePort;
import com.pragma.microserviciousuarios.infrastructure.security.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationPersistenceAdapter implements AuthenticationPersistencePort {
    private final JwtUtil jwtUtil;


    @Override
    public String generateToken(UserModel user) {
        return jwtUtil.generateToken(user);
    }

}
