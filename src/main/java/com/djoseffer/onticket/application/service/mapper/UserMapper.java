package com.djoseffer.onticket.application.service.mapper;

import com.djoseffer.onticket.adapters.in.api.dto.UserRegisterDto;
import com.djoseffer.onticket.adapters.in.api.dto.UserResponseDto;
import com.djoseffer.onticket.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    User convertUserRegisterDtotoUser(UserRegisterDto userRegisterDto);


    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    UserResponseDto convertUserToUserResponseDto(User user);
}
