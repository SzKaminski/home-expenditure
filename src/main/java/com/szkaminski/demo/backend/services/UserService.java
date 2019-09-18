package com.szkaminski.demo.backend.services;

import com.szkaminski.demo.backend.model.User;
import com.szkaminski.demo.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
