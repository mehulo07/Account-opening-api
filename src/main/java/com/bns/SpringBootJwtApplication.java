package com.bns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootJwtApplication extends SpringBootServletInitializer{

	private static final Logger LOGGER = LogManager.getLogger(SpringBootJwtApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("test");
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}
	  
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
    	return springApplicationBuilder.sources(SpringBootJwtApplication.class);
    }
	

}
