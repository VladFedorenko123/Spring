package com.srccode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.srccode.interfaces.MongoTextRepository;
import com.srccode.interfaces.MySQLTextRepository;

@EnableMongoRepositories(basePackageClasses = MongoTextRepository.class)
@EnableJpaRepositories(basePackageClasses = MySQLTextRepository.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
