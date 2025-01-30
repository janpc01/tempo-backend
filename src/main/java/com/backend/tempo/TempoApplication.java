package com.backend.tempo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TempoApplication {

	private static final Logger logger = LoggerFactory.getLogger(TempoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting TempoApplication...");
		SpringApplication.run(TempoApplication.class, args);
		logger.info("TempoApplication started successfully.");
	}

}
