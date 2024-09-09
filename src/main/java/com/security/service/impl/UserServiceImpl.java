package com.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.User;
import com.security.repository.UserRespository;
import com.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public User createUser(User user) {
        User existUser = userRespository.findByUsername(user.getUsername());

        if (existUser != null) throw new Error("User already exists!");

        return null;
    }
    
}
