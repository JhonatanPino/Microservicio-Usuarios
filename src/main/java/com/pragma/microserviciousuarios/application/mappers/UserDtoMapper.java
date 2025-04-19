package com.pragma.microserviciousuarios.application.mappers;

import com.pragma.microserviciousuarios.application.dto.request.SaveUserRequest;
import com.pragma.microserviciousuarios.domain.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserDtoMapper {

    @Mapping(target = "role.id", source = "idRole")
    UserModel requestToModel(SaveUserRequest saveUserRequest);
}
