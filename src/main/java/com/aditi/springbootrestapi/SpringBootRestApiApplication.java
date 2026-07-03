package com.aditi.springbootrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}

}
