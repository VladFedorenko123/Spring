package com.srccode.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srccode.clas.JsonBuilder;
import com.srccode.clas.MongoDBConnection;
import com.srccode.clas.MySQLReadText;
import com.srccode.clas.ReadFile;
import com.srccode.enums.InputType;
import com.srccode.interfaces.ConnectMongoDB;
import com.srccode.interfaces.Json;
import com.srccode.interfaces.Reader;

@RestController
public class Controller {
	Json json = new JsonBuilder();
	Reader reader = new ReadFile();
	Reader mySQL = new MySQLReadText();
	ConnectMongoDB mongo = new MongoDBConnection();

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
		return json.getJson(inputType, mySQL.getText());
	}

	@GetMapping("/mongo")
	public String getMongo() {
		String inputType = InputType.MONGODB.getInputType();
		return json.getJson(inputType, mongo.connection());
	}
}
