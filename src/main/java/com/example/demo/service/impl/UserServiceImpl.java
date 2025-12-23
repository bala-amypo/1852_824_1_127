package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository obj;

    public User saveUser(User user) {
        return obj.save(user);
    }

    public User findByEmail(String email) {
        return obj.findByEmail(email).orElse(null);
    }
}
