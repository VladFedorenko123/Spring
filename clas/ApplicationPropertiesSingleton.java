package com.srccode.clas;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesSingleton {
    private static ApplicationPropertiesSingleton instance = null;
    private static Properties properties = null;
    public String ip = null;
    public String port = null;

    protected ApplicationPropertiesSingleton() {
        try (InputStream input = new FileInputStream("/home/vlad/MyJava/springapplication/application.properties")) {
            properties = new Properties();
            properties.load(input);

            ip = properties.getProperty("memcache.ip");
            port = properties.getProperty("memcache.port");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ApplicationPropertiesSingleton getInstance() {
        if (instance == null) {
            instance = new ApplicationPropertiesSingleton();
        }
        return instance;
    }
}
