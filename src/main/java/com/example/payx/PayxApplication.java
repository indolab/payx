package com.example.payx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PayxApplication {

	public static void main(String[] args) {
		// this is main class
		SpringApplication.run(PayxApplication.class, args);
	}

}
