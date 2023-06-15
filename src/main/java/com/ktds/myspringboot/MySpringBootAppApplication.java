package com.ktds.myspringboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//configuration + componentScan + enableAutoConfiguration
public class MySpringBootAppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MySpringBootAppApplication.class, args);
		SpringApplication application = new SpringApplication(MySpringBootAppApplication.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
