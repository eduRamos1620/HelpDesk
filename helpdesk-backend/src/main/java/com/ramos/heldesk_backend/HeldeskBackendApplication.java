package com.ramos.heldesk_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HeldeskBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeldeskBackendApplication.class, args);
	}

}
