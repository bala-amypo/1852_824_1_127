package com.example.demo.service;
  import com.example.demo.entity.User;
  import com.

public interface  UserService(){
User saveUser(User user);
User findByEmail(String email);
}