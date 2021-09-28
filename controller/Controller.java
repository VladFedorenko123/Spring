package com.srccode.controller;

import ch.qos.logback.classic.Logger;
import com.srccode.clas.*;
import com.srccode.interfaces.*;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srccode.dto.LineAfterAnalysesDTO;
import com.srccode.dto.TextMySQLDTO;
import com.srccode.enums.InputType;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller {
    Json json = new JsonBuilder();
    Reader reader = new ReadFile();
    Vowels vowels = new VowelsCalculator();
    Consonants consonants = new ConsonantsCalculator();
    Time timestamp = new TimeStamp();
    Counter counter = new CounterRequest();
    Memcached memcached = new MemcachedImplementation();
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);

    @Autowired
    private MongoTextRepository mongoRepository;

    @Autowired
    private MySQLTextRepository mySQLRepository;

    @Autowired
    private MongoPutTextRepository putRepository;


    @PostMapping("/newstring")
    public String addString(@RequestParam String newString,
                            LineAfterAnalysesDTO mongoDTO) {
        String text = null;
        String res = null;
        String result = null;
        if (newString.isEmpty()) {
            result = "Error: text can't be empty";
            logger.error("Error: text can't be empty");
        } else {
            String inputType = InputType.NEWSTRING.getInputType();
            TextMySQLDTO existed = mySQLRepository.findBySrc(newString);
            TextMySQLDTO str = new TextMySQLDTO();
            if (existed == null) {
                str.setSrc(newString);
                mySQLRepository.save(str);
                text = "Saved: " + newString;
                memcached.mCache(str.getId().toString(),str.getSrc());
            } else {
                text = existed.getSrc() + " This name is in the database";
               memcached.mCache(existed.getId().toString(),existed.getSrc());
            }

            //MongoDB
            LineAfterAnalysesDTO name = putRepository.findByStr(newString);
            if (name == null) {
                mongoDTO.setStr(newString);
                mongoDTO.setVowelsNumber(vowels.getVowels(newString));
                mongoDTO.setConsonantsNumber(consonants.getConsonants(newString));
                mongoDTO.setTimestamp(timestamp.getTimestamp());
                mongoDTO.setRequestCounter(counter.requestCounter("0"));
                putRepository.save(mongoDTO);
                res = json.getJson(inputType, newString, putRepository.findByStr(newString)
                        .getRequestCounter());
            } else {
                name.setRequestCounter(counter.requestCounter(putRepository.findByStr(newString)
                        .getRequestCounter()));
                putRepository.save(name);
                res = json.getJson(inputType, newString, putRepository.findByStr(newString)
                        .getRequestCounter());
            }
        }
        result = text + "\n\n" + res;
        return result;
    }

    @PostMapping("/console")
    public String getConsole() {
        String text = "vlad";
        String inputType = InputType.CONSOLE.getInputType();
        return json.getJson(inputType, text, "0");
    }

    @GetMapping("/file")
    public String getFile() {
        String inputType = InputType.FILE.getInputType();
        return json.getJson(inputType, reader.getText(), "0");
    }

    @GetMapping("/mysql")
    public String getMySQl() {
        String inputType = InputType.MYSQL.getInputType();
        return json.getJson(inputType, mySQLRepository.findAll().toString(), "0");
    }

    @GetMapping("/mongo")
    public String getMongo(@RequestParam ObjectId id) {
        String inputType = InputType.MONGODB.getInputType();
        return json.getJson(inputType, mongoRepository.findById(id).stream().findAny().get().getId().toString(), "0");
    }
}
