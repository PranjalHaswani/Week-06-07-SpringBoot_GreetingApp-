package com.example.GreetingAppDevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.model")
@SpringBootApplication(scanBasePackages = "com.example")
public class GreetingAppDevelopmentApplication {

	public static void main(String[] args) {

		SpringApplication.run(GreetingAppDevelopmentApplication.class, args);
	}
}
