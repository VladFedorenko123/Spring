package com.srccode.clas;

import java.sql.Connection;
import java.sql.DriverManager;

import com.srccode.interfaces.ConnectMySQL;

public class MySQLConnection implements ConnectMySQL {
	@Override
	public Connection connection() {
		try {
			PropertySingleton properties = new PropertySingleton();
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(properties.sqlUrl, properties.sqlUser, properties.sqlPassword);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

}
