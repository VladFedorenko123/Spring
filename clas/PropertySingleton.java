package com.srccode.clas;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertySingleton {
	private static PropertySingleton instance = null;
	private static Properties properties = null;
	public String mongoUrl = null;
	public String mongoPort = null;
	public String mongoDatabase = null;
	public String mongoCollection = null;
	public String sqlUrl = null;
	public String sqlUser = null;
	public String sqlPassword = null;

	protected PropertySingleton() {
		try (InputStream input = new FileInputStream(
				"/home/vlad/eclipse-workspace/springapplication/aplication.properties")) {
			properties = new Properties();
			properties.load(input);

			mongoUrl = properties.getProperty("database.mongoUrl");
			mongoPort = properties.getProperty("database.mongoPort");
			mongoDatabase = properties.getProperty("database.mongoDatabase");
			mongoCollection = properties.getProperty("database.mongoCollection");
			sqlUrl = properties.getProperty("database.mysqlUrl");
			sqlUser = properties.getProperty("database.mysqlUser");
			sqlPassword = properties.getProperty("database.mysqlPassword");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static PropertySingleton getInstance() {
		if (instance == null) {
			instance = new PropertySingleton();
		}
		return instance;
	}
}
