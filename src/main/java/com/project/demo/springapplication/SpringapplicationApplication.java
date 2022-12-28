package com.project.demo.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringapplicationApplication {

	public static void main(String[] args) {
		System.out.println("#### MAP = "+System.getenv());
		SpringApplication.run(SpringapplicationApplication.class, args);
	}

}
