package com.example.demo2.Services;

import com.example.demo2.Models.User;
import com.example.demo2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "User added successfully";
    }
}
