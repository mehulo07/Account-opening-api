package com.bns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootJwtApplication {

	private static final Logger LOGGER = LogManager.getLogger(SpringBootJwtApplication.class);
	public static void main(String[] args) {
		LOGGER.info("test");
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}
	
	
}
