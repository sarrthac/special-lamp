package com.fireshadow01.springboot_backend.service.impl;

import com.fireshadow01.springboot_backend.dto.UserDto;
import com.fireshadow01.springboot_backend.entity.Useraaaaaaaaaaaa;
import com.fireshadow01.springboot_backend.exceptions.ResourceNotFoundException;
import com.fireshadow01.springboot_backend.mapper.UserMapper;
import com.fireshadow01.springboot_backend.repository.UseraaaaaaaaaaaaRepository;
import com.fireshadow01.springboot_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UseraaaaaaaaaaaaRepository useraaaaaaaaaaaaRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Useraaaaaaaaaaaa useraaaaaaaaaaaa = UserMapper.mapToUser(userDto);
        Useraaaaaaaaaaaa savedUseraaaaaaaaaaaa = useraaaaaaaaaaaaRepository.save(useraaaaaaaaaaaa);
        return UserMapper.mapToUserDto(savedUseraaaaaaaaaaaa);
    }

    @Override
    public UserDto getUserById(Long userId) {
       Useraaaaaaaaaaaa useraaaaaaaaaaaa = useraaaaaaaaaaaaRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist with the given Id :  "+ userId));
        return UserMapper.mapToUserDto(useraaaaaaaaaaaa);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Useraaaaaaaaaaaa> useraaaaaaaaaaaas = useraaaaaaaaaaaaRepository.findAll();
        return useraaaaaaaaaaaas.stream().map((useraaaaaaaaaaaa) -> UserMapper.mapToUserDto(useraaaaaaaaaaaa))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        Useraaaaaaaaaaaa useraaaaaaaaaaaa = useraaaaaaaaaaaaRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist with the given Id :  "+ userId));

        useraaaaaaaaaaaa.setFirstName(updatedUser.getFirstName());
        useraaaaaaaaaaaa.setLastName(updatedUser.getLastName());
        useraaaaaaaaaaaa.setEmail(updatedUser.getEmail());

        Useraaaaaaaaaaaa updatedUseraaaaaaaaaaaaObj = useraaaaaaaaaaaaRepository.save(useraaaaaaaaaaaa);
        return UserMapper.mapToUserDto(updatedUseraaaaaaaaaaaaObj);
    }
}
