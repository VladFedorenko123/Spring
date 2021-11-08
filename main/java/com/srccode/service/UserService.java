package com.srccode.service;

import com.srccode.dao.UserRepository;
import com.srccode.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    User user = new User();

    @Autowired
    private UserRepository userRepository;

    public void saveUser(String name) {
        if (name.isEmpty()) {
            logger.error("Error: text can not be empty!");
        } else {
            if (userRepository.findBySrc(name) == null) {
                user.setSrc(name);
                userRepository.save(user);
            } else {
                logger.error("This name is in database!");
            }
        }
    }
}
