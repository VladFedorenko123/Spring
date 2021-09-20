package com.srccode.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.Test;

class ReadFileTest {

	@Test
	void test() {
		String path = "/home/vlad/eclipse-workspace/springapplication/myfile.txt";
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		assertTrue(absolutePath.endsWith("/home/vlad/eclipse-workspace/springapplication/myfile.txt"));
	}
}
