package com.srccode.test;

import com.srccode.dto.TextMySQLDTO;
import com.srccode.interfaces.MySQLTextRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySQLTest {
    @Resource
    private MySQLTextRepository mySQLTextRepository;

    @Test
    public void test() {
        TextMySQLDTO textMySQLDTO = new TextMySQLDTO(1, "Petro");
        mySQLTextRepository.save(textMySQLDTO);
        mySQLTextRepository.findById(1);
        assertEquals("Petro", textMySQLDTO.getSrc());
        assertEquals(1, textMySQLDTO.getId());
    }
}
