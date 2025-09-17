package io.edu.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.edu.user.dto.UserCreateDTO;
import io.edu.user.dto.UserDTO;
import io.edu.user.model.User;

@Mapper (componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", expression = "java(io.edu.user.model.UserStatus.PENDING)")
    User toEntity(UserCreateDTO userCreateDTO);
}
