package com.srccode.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Analyses")
public class LineAfterAnalysesDTO {
	@Id
	private ObjectId id;
	private String str;
	private String vowelsNumber;
	private String consonantsNumber;
	private String timestamp;

	public LineAfterAnalysesDTO(String vowelsNumber, String consonantsNumber, String timestamp) {
		this.vowelsNumber = vowelsNumber;
		this.consonantsNumber = consonantsNumber;
		this.timestamp = timestamp;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public String getVowelsNumber() {
		return vowelsNumber;
	}

	public void setVowelsNumber(String vowelsNumber) {
		this.vowelsNumber = vowelsNumber;
	}

	public String getConsonantsNumber() {
		return consonantsNumber;
	}

	public void setConsonantsNumber(String consonantsNumber) {
		this.consonantsNumber = consonantsNumber;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
