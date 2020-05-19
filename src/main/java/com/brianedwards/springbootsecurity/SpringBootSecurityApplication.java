package com.brianedwards.springbootsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication {

	public static void main(String[] args) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		// outputs {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
		// remember the password that is printed out and use in the next step
		System.out.println("Encoded Password: " + encoder.encode("secret"));

		System.out.println("User ID is Brian and password is secret");



		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

}
