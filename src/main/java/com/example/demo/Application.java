package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import foo.bar.WelcomeMessage;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		var WelcomeMessage = new WelcomeMessage();
		System.out.println(WelcomeMessage.getWelcomeMessage());
	}

}
