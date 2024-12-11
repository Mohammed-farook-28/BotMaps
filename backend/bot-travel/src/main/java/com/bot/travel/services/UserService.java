package com.bot.travel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.travel.models.User;
import com.bot.travel.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId); 
    }

    public User updateUser(String userId, User updatedUser) {
        User existingUser = userRepository.findByUserId(userId); 
        if (existingUser != null) {
            updatedUser.setUserId(userId);           
            return userRepository.save(updatedUser); 
        }
        return null; 
    }
}
