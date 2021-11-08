package com.srccode.implementation;

import com.srccode.interfaces.Consonants;
import com.srccode.interfaces.Reader;
import com.srccode.interfaces.Vowels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead implements Reader {
    Vowels vowels = new VowelsCalculator();
    Consonants consonants = new ConsonantsCalculator();
    @Override
    public String getText() {
        String result = null;
        try {
            String path = "/home/vlad/MyJava/spring/file";
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String textReader, text = null;
            while ((textReader = bufferedReader.readLine()) != null) {
                text = textReader;
            }
            result = text + "\nvowels: " + vowels.getVowels(text) + "\nconsonants: " + consonants.getConsonants(text);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
