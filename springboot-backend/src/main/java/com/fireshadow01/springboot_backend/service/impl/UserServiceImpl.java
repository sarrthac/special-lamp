package com.fireshadow01.springboot_backend.service.impl;

import com.fireshadow01.springboot_backend.dto.UserDto;
import com.fireshadow01.springboot_backend.entity.User;
import com.fireshadow01.springboot_backend.exceptions.ResourceNotFoundException;
import com.fireshadow01.springboot_backend.mapper.UserMapper;
import com.fireshadow01.springboot_backend.repository.UserRepository;
import com.fireshadow01.springboot_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
       User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist with the given Id :  "+ userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist with the given Id :  "+ userId));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());

        User updatedUserObj = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);
    }
}
