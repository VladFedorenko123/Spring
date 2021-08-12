package com.srccode.controller;

import java.util.ArrayList;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srccode.clas.ConsonantsCalculator;
import com.srccode.clas.JsonBuilder;
import com.srccode.clas.MySQLReadText;
import com.srccode.clas.ReadFile;
import com.srccode.clas.TimeStamp;
import com.srccode.clas.VowelsCalculator;
import com.srccode.dto.TextMongoDTO;
import com.srccode.dto.TextMySQLDTO;
import com.srccode.enums.InputType;
import com.srccode.interfaces.Consonants;
import com.srccode.interfaces.Json;
import com.srccode.interfaces.Reader;
import com.srccode.interfaces.Time;
import com.srccode.interfaces.Vowels;

import com.srccode.interfaces.MongoTextRepository;
import com.srccode.interfaces.MySQLTextRepository;

@RestController
public class Controller {
	Json json = new JsonBuilder();
	Reader reader = new ReadFile();
	Reader mySQL = new MySQLReadText();
	Vowels vowels = new VowelsCalculator();
	Consonants consonants = new ConsonantsCalculator();
	Time timestamp = new TimeStamp();

	@Autowired
	private MongoTextRepository mongoRepository;

	@Autowired
	private MySQLTextRepository mySQLRepository;

	@PostMapping("/newstring")
	public String addString(@RequestParam String newString) {
		String inputType = InputType.NEWSTRING.getInputType();
		TextMySQLDTO str = new TextMySQLDTO();
		str.setStr(newString);
		return json.getJson(inputType, mySQLRepository.save(str).toString());
	}

	@PostMapping("/putAnalyze")
	public TextMongoDTO putAnalyze(@RequestParam String number, TextMongoDTO mongoDTO) {
		List<TextMySQLDTO> list = (ArrayList<TextMySQLDTO>) mySQLRepository.findAll();
		String text = list.get(Integer.parseInt(number)).toString();
		mongoDTO.setStr(text);
		return mongoRepository.save(mongoDTO);

	}

	@PostMapping("/console")
	public String getConsole() {
		String text = "vlad";
		String inputType = InputType.CONSOLE.getInputType();
		return json.getJson(inputType, text);
	}

	@GetMapping("/file")
	public String getFile() {
		String inputType = InputType.FILE.getInputType();
		return json.getJson(inputType, reader.getText());
	}

	@GetMapping("/mysql")
	public String getMySQl() {
		String inputType = InputType.MYSQL.getInputType();
		return json.getJson(inputType, mySQLRepository.findAll().toString());
	}

	@GetMapping("/mongo")
	public String getMongo(@RequestParam ObjectId id) {
		String inputType = InputType.MONGODB.getInputType();
		return json.getJson(inputType, mongoRepository.findById(id).stream().findAny().get().getStr().toString());
	}
}
