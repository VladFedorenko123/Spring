package com.srccode.test;

import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    void test() {
        String path = "/home/vlad/MyJava/springapplication/myfile.txt";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        assertTrue(absolutePath.endsWith("/home/vlad/MyJava/springapplication/myfile.txt"));
    }
}
