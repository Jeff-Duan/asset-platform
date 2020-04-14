package com.demo.asset.service;

import com.demo.asset.data.UserRepository;
import com.demo.asset.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User find(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    public User find(String name, String password) {
        return userRepository.findByNameAndPassword(name, password).orElse(null);
    }
    
}
