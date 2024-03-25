package com.hamza.Gestion_bank.mappers;

import com.hamza.Gestion_bank.dto.UserDTO;
import com.hamza.Gestion_bank.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    User mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);
}
