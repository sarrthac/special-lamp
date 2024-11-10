package com.fireshadow01.springboot_backend.controllers;

import com.fireshadow01.springboot_backend.dto.UserDto;
import com.fireshadow01.springboot_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;


    //Add User
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
       UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    //Get User By Id
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId)
    {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }


    //Get All Users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto updatedUser)
    {
        UserDto userDto = userService.updateUser(userId,updatedUser);
        return ResponseEntity.ok(userDto);
    }
}
