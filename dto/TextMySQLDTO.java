package com.srccode.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "srctable")
public class TextMySQLDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	private String src;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStr(String src) {
		this.src = src;
	}

	public String getStr() {
		return src;
	}

	@Override
	public String toString() {
		return src;
	}
}
