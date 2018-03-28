package com.nightplex.apibuddy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by NightPlex on 3/28/2018
 * Github: https://github.com/NightPlex
 */

@SpringBootApplication
public class ApiBuddyApplication {

	private static final Logger logger = LogManager.getLogger(ApiBuddyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiBuddyApplication.class, args);
		logger.info("Application started");
	}
}
