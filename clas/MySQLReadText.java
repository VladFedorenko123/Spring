package com.srccode.clas;

import java.sql.ResultSet;
import java.sql.Statement;

import com.srccode.interfaces.ConnectMySQL;
import com.srccode.interfaces.Reader;

public class MySQLReadText implements Reader {
	ConnectMySQL con = new MySQLConnection();

	@Override
	public String getText() {
		try {
			Statement statement = con.connection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
			String sqlText = null;
			while (resultSet.next()) {
				String text1 = resultSet.getString(2);
				sqlText = text1;
			}
			return sqlText;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
