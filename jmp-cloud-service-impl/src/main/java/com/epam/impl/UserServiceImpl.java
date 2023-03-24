package com.epam.impl;

import com.epam.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
