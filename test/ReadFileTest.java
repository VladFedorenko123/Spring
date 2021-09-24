package com.srccode.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.Test;

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
