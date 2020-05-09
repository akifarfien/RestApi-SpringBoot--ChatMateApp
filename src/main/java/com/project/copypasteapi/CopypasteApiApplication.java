package com.project.copypasteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CopypasteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CopypasteApiApplication.class, args);
	}

}
