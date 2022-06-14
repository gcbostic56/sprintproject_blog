package com.example.sprintproject_blog.service;

import com.example.sprintproject_blog.model.User;
import com.example.sprintproject_blog.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);

    List<User> getAllUsers();
}
