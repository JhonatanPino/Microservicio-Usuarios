package com.pragma.microserviciousuarios.application.mappers;

import com.pragma.microserviciousuarios.application.dto.request.SaveUserRequest;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserDtoMapper {

    UserModel requestToModel(SaveUserRequest saveUserRequest);
}
