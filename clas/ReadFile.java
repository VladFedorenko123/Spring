package com.srccode.clas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.srccode.interfaces.Reader;

public class ReadFile implements Reader {
	@Override
	public String getText() {
		try {
			String path = "/home/vlad/eclipse-workspace/springapplication/myfile.txt";
			File file = new File(path);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String textReader, text = null;
			while ((textReader = bufferedReader.readLine()) != null) {
				text = textReader;
			}
			bufferedReader.close();
			return text;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
