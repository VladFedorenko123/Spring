package com.srccode.test;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileReadTest {

    @Test
    void getText() {
        String path = "/home/vlad/MyJava/spring/file";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        assertTrue(absolutePath.endsWith("/home/vlad/MyJava/spring/file"));
    }
}