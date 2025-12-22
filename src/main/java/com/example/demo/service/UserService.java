package com.example.demo.service;
import com.example.demo.entity.User;
public interface UserService {
    User saveUser(User user);
    User registerCustomer(String name, String email);
    User findByEmail(String email);
    User findById(Long id);
}
