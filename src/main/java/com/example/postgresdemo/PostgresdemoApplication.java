package com.example.postgresdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class PostgresdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresdemoApplication.class, args);
	}

}
