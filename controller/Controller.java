package com.srccode.controller;

import ch.qos.logback.classic.Logger;
import com.srccode.dao.JsonBuilder;
import com.srccode.repository.LineAfterAnalysesRepository;
import com.srccode.repository.UserRepository;
import com.srccode.service.LineAfterAnalysesService;
import com.srccode.service.UserService;
import com.srccode.ui.Json;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);

    Json json = new JsonBuilder();
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LineAfterAnalysesService lineAfterAnalysesService;
    @Autowired
    private LineAfterAnalysesRepository lineAfterAnalysesRepository;

    @PostMapping("/name")
    public String addUser(@RequestParam String name) {
        String text;
        String textMongo ;
        String result;
        if (name.isEmpty()) {
            text = "Error: text can't be empty";
            logger.error("Error: text can't be empty");
        } else {
            if (userRepository.findBySrc(name) == null) {
                userService.saveUser(name);
                text = "This name saved to database: " + name;
            } else {
                text = "This name is in database";
                logger.error("This name is in database");
            }
        }
        if (lineAfterAnalysesRepository.findByStr(name) == null) {
            lineAfterAnalysesService.saveAnalyses(name);
            textMongo = json.getJson(lineAfterAnalysesService.findName(name),
                    lineAfterAnalysesService.findVowels(name),
                    lineAfterAnalysesService.findConsonants(name),
                    lineAfterAnalysesService.findTimestamp(name),
                    lineAfterAnalysesService.findRequestCounter(name));
        } else {
            lineAfterAnalysesService.findAnalyses(name);
            textMongo = json.getJson(lineAfterAnalysesService.findName(name),
                    lineAfterAnalysesService.findVowels(name),
                    lineAfterAnalysesService.findConsonants(name),
                    lineAfterAnalysesService.findTimestamp(name),
                    lineAfterAnalysesService.findRequestCounter(name));

        }
        result = text + "\n\n" + textMongo;
        return result;
    }
}
