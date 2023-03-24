package com.epam.controller;

import com.epam.dto.User;
import com.epam.dto.UserRequestDto;
import com.epam.dto.UserResponseDto;
import com.epam.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("provides an interface for operations on the User entity")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation("Create user")
    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        User user = userService.createUser(convertToUser(userRequestDto));
        return convertToUserResponseDto(user);
    }

    @ApiOperation("Update user")
    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto updateUser(@RequestBody UserRequestDto userRequestDto){
        User user = userService.updateUser(convertToUser(userRequestDto));
        return convertToUserResponseDto(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Delete user by id")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Retrieve used by id")
    public UserResponseDto getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        return convertToUserResponseDto(user);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Retrieve all users")
    public List<UserResponseDto> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return allUser.stream()
                .map(this::convertToUserResponseDto).toList();
    }

    private User convertToUser(UserRequestDto userRequestDto){
        return modelMapper.map(userRequestDto, User.class);
    }

    private UserResponseDto convertToUserResponseDto(User user){
        return modelMapper.map(user, UserResponseDto.class);
    }
}
