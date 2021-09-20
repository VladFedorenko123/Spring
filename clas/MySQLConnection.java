package com.srccode.clas;

import org.springframework.beans.factory.annotation.Autowired;

import com.srccode.dto.TextMySQLDTO;
import com.srccode.interfaces.MySQLTextRepository;
import com.srccode.interfaces.SaveMySQL;

public class MySQLConnection implements SaveMySQL {
	@Autowired
	private MySQLTextRepository mySQLRepository;

	@Override
	public void saved(String newString) {
		TextMySQLDTO str = new TextMySQLDTO();
		str.setStr(newString);
		mySQLRepository.save(str);
	}

}
