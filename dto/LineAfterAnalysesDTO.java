package com.srccode.dto;

import java.sql.Timestamp;

public class LineAfterAnalysesDTO {
	private int vowelsNumber;
	private int consonantsNumber;
	private Timestamp timestamp;

	public LineAfterAnalysesDTO(int vowelsNumber, int consonantsNumber, Timestamp timestamp) {
		this.vowelsNumber = vowelsNumber;
		this.consonantsNumber = consonantsNumber;
		this.timestamp = timestamp;
	}

	public LineAfterAnalysesDTO() {

	}

	public int getVowelsNumber() {
		return vowelsNumber;
	}

	public void setVowelsNumber(int vowelsNumber) {
		this.vowelsNumber = vowelsNumber;
	}

	public int getConsonantsNumber() {
		return consonantsNumber;
	}

	public void setConsonantsNumber(int consonantsNumber) {
		this.consonantsNumber = consonantsNumber;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
