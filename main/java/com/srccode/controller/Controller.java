package com.srccode.controller;

import com.srccode.implementation.FileRead;
import com.srccode.interfaces.Reader;
import com.srccode.service.LineAfterAnalysesService;
import com.srccode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Reader reader = new FileRead();

    @Autowired
    private UserService userService;

    @Autowired
    private LineAfterAnalysesService lineAfterAnalysesService;

    @PostMapping("/name")
    @Cacheable(value = "name")
    public void addUser(@RequestParam String name) {
        userService.saveUser(name);
        lineAfterAnalysesService.saveLineAfterAnalyses(name);
    }

    @GetMapping("/name/read")
    public String readAnalyses(@RequestParam String name) {
        return lineAfterAnalysesService.readLineAfterAnalyses(name);
    }

    @GetMapping("/file")
    public String readFile() {
        return reader.getText();
    }
}
