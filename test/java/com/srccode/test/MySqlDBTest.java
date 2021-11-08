package com.srccode.test;

import com.srccode.dao.UserRepository;
import com.srccode.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySqlDBTest {
    User user = new User(1, "Petro");

    @Autowired
    private UserRepository userRepository;

    @Test
    public void MySqlDbTest() {
        userRepository.save(user);
        userRepository.findById(1);
        assertEquals("Petro", user.getSrc());
        assertEquals(1, user.getId());
    }
}
