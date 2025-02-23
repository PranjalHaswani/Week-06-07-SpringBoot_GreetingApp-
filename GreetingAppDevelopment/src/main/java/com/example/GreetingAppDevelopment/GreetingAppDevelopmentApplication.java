package com.example.GreetingAppDevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class GreetingAppDevelopmentApplication {

	public static void main(String[] args) {

		SpringApplication.run(GreetingAppDevelopmentApplication.class, args);
	}

}
