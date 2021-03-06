package com.domgarr.concetto.api.v1.mapper;

import com.domgarr.concetto.api.v1.model.UserDTO;
import com.domgarr.concetto.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
}
