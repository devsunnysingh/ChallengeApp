package com.devsunnysingh.ChallengeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication

public class ChallengeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeAppApplication.class, args);
		System.out.println("Hello");
	}

}
