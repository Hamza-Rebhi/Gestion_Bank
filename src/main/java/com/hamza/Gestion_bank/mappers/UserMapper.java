package com.hamza.Gestion_bank.mappers;

import com.hamza.Gestion_bank.dto.UserDTO;
import com.hamza.Gestion_bank.entities.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    UserInfo mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(UserInfo user);
}
