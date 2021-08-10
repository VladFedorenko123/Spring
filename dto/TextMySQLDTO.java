package com.srccode.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mytable")
public class TextMySQLDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer _id;

	private String str;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		this._id = id;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	@Override
	public String toString() {
		return str;
	}
}
