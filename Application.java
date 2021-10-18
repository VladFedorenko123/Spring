package com.srccode;

import com.srccode.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableCaching
@EnableAutoConfiguration
public class Application implements CommandLineRunner {
    @Autowired
    ApplicationProperties applicationProperties;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String ip = applicationProperties.getIp();
        int port = applicationProperties.getPort();
        System.out.println("IP: " + ip);
        System.out.println("PORT: " + port);
    }
}
