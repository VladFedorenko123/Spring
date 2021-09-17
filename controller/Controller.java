package com.srccode.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srccode.clas.ConsonantsCalculator;
import com.srccode.clas.JsonBuilder;
import com.srccode.clas.ReadFile;
import com.srccode.clas.TimeStamp;
import com.srccode.clas.VowelsCalculator;
import com.srccode.dto.LineAfterAnalysesDTO;
import com.srccode.dto.TextMySQLDTO;
import com.srccode.enums.InputType;
import com.srccode.interfaces.Consonants;
import com.srccode.interfaces.Json;
import com.srccode.interfaces.MongoPutTextRepository;
import com.srccode.interfaces.Reader;
import com.srccode.interfaces.Time;
import com.srccode.interfaces.Vowels;

import com.srccode.interfaces.MongoTextRepository;
import com.srccode.interfaces.MySQLTextRepository;

@RestController
public class Controller {
	Json json = new JsonBuilder();
	Reader reader = new ReadFile();
	Vowels vowels = new VowelsCalculator();
	Consonants consonants = new ConsonantsCalculator();
	Time timestamp = new TimeStamp();

	@Autowired
	private MongoTextRepository mongoRepository;

	@Autowired
	private MySQLTextRepository mySQLRepository;

	@Autowired
	private MongoPutTextRepository putRepository;

	@PostMapping("/newstring")
	public String addString(@RequestParam String newString, LineAfterAnalysesDTO mongoDTO) {
		String inputType = InputType.NEWSTRING.getInputType();
		TextMySQLDTO existed = mySQLRepository.findBySrc(newString);
		TextMySQLDTO str = new TextMySQLDTO();
		String text = null;
		String res = null;
		if (existed == null) {
			str.setStr(newString);
			mySQLRepository.save(str);
			text = "Saved: " + newString;

		} else {
			text = existed.getStr() + " This name is in the database";
		}
		if (putRepository.findByStr(newString) == null) {
			mongoDTO.setStr(newString);
			mongoDTO.setVowelsNumber(vowels.getVowels(newString));
			mongoDTO.setConsonantsNumber(consonants.getConsonants(newString));
			mongoDTO.setTimestamp(timestamp.getTimestamp());
			putRepository.save(mongoDTO);
			res = json.getJson(inputType, newString);
		} else {
			res = json.getJson(inputType, newString);
		}
		String result = text + "\n" + res;
		return result;
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
		return json.getJson(inputType, mongoRepository.findById(id).stream().findAny().get().getId().toString());
	}
}
