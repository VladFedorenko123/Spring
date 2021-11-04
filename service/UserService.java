package com.srccode.service;

import com.srccode.model.User;
import com.srccode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    User user = new User();

    @Autowired
    private UserRepository userRepository;

    public void saveUser(String name) {
        user.setSrc(name);
        userRepository.save(user);
    }

    public String getUser(String name) {
        return userRepository.findBySrc(name).getSrc();
    }
}
