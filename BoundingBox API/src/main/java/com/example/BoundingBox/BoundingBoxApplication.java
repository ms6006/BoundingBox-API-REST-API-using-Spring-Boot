package com.example.BoundingBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.BoundingBox")
public class BoundingBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoundingBoxApplication.class, args);
	}

}
