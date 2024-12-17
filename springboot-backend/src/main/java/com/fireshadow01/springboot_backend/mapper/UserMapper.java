package com.fireshadow01.springboot_backend.mapper;

import com.fireshadow01.springboot_backend.dto.UserDto;
import com.fireshadow01.springboot_backend.entity.Useraaaaaaaaaaaa;

public class UserMapper {

    public static UserDto mapToUserDto(Useraaaaaaaaaaaa useraaaaaaaaaaaa)
    {
        return new UserDto(
                useraaaaaaaaaaaa.getId(),
                useraaaaaaaaaaaa.getFirstName(),
                useraaaaaaaaaaaa.getLastName(),
                useraaaaaaaaaaaa.getEmail()
        );
    }


    public static Useraaaaaaaaaaaa mapToUser(UserDto userDto)
    {
        return new Useraaaaaaaaaaaa(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }

}
