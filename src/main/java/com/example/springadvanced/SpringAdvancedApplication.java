package com.example.springadvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdvancedApplication.class, args);
	}

}
