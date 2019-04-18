package com.tanson.tesecase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TesecaseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TesecaseApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TesecaseApplication.class);
	}

}
