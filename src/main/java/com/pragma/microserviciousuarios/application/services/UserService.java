package com.pragma.microserviciousuarios.application.services;

import com.pragma.microserviciousuarios.application.dto.request.SaveUserRequest;
import com.pragma.microserviciousuarios.application.dto.response.SaveUserResponse;

public interface UserService {
    SaveUserResponse saveUser (SaveUserRequest request);
}
