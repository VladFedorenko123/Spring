package com.srccode.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Analyses")
public class LineAfterAnalysesDTO {
	@Id
	private ObjectId id;
	private String vowelsNumber;
	private String consonantsNumber;
	private String timestamp;

	public LineAfterAnalysesDTO(String vowelsNumber, String consonantNumber, String timestamp) {
		this.vowelsNumber = vowelsNumber;
		this.consonantsNumber = consonantNumber;
		this.timestamp = timestamp;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getVowelsNumber() {
		return vowelsNumber;
	}

	public void setVowelsNumber(String vowelsNumber) {
		this.vowelsNumber = vowelsNumber;
	}

	public String getConsonantNumber() {
		return consonantsNumber;
	}

	public void getConsonantNumber(String consonantNumber) {
		this.consonantsNumber = consonantNumber;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
