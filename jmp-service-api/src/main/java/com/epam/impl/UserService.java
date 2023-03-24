package com.epam.impl;

import com.epam.dto.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User userRequestDto);

    void deleteUser(Long id);

    User getUser(Long id);

    List<User> getAllUser();
}
