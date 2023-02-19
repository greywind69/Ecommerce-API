package com.example.Ecommerce.API.Service;

import com.example.Ecommerce.API.Repository.UserRepository;

import com.example.Ecommerce.API.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(User user){
        userRepository.save(user);
        return "User is Saved";
    }

    public User get(Integer userId) {
        return userRepository.findById(userId).get();
    }
}