package com.bns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
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
    
    
    @Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.any())
				.build()
				.apiInfo(apiDetails());
	}
	
	
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Account Opening Service", "Documentation of Account Opening Rest service", "1.0",
				"Free to use", 
				new springfox.documentation.service.Contact("Luxsh Technologies LTD.","http://luxshtech.com/", "hussain.doctor@bnscolorama.co.uk"),
				"API Liceance", 
				"http://luxshtech.com/index.html", 
				java.util.Collections.EMPTY_LIST
				);
	}
	
	

}
