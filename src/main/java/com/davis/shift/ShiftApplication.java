package com.davis.shift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication
public class ShiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiftApplication.class, args);
	}
}
