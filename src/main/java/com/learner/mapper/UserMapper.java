package com.learner.mapper;

import com.learner.dto.UserDto;
import com.learner.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping()
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

}
