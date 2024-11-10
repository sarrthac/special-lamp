package com.fireshadow01.springboot_backend.mapper;

import com.fireshadow01.springboot_backend.dto.UserDto;
import com.fireshadow01.springboot_backend.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user)
    {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }


    public static User mapToUser(UserDto userDto)
    {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }

}
