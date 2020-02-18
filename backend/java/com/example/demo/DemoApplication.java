package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"net", "com.example.demo"}) 
public class DemoApplication {

	public static void main(String[] args) {
		InitDb.initDb();
		SpringApplication.run(DemoApplication.class, args);
	}

}
