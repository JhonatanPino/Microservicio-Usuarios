package com.pragma.microserviciousuarios.infrastructure.mappers;

import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity modelToEntity(UserModel userModel);

    UserModel entityToModel(UserEntity userEntity);
}
