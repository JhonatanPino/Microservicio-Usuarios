package com.pragma.microserviciousuarios.application.services.impl;

import com.pragma.microserviciousuarios.application.dto.request.SaveUserRequest;
import com.pragma.microserviciousuarios.application.dto.response.SaveUserResponse;
import com.pragma.microserviciousuarios.application.mappers.UserDtoMapper;
import com.pragma.microserviciousuarios.application.services.UserService;
import com.pragma.microserviciousuarios.commons.configuration.utils.Constants;
import com.pragma.microserviciousuarios.domain.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDtoMapper userDtoMapper;
    private final UserServicePort userServicePort;

    @Override
    public SaveUserResponse saveUser(SaveUserRequest request) {
        userServicePort.saveUser(userDtoMapper.requestToModel(request));
        return new SaveUserResponse(Constants.SAVE_USER_RESPONSE_MESSAGE, LocalDateTime.now());
    }
}
