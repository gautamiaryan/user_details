package com.calorian.userdetailss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class UserDetailssApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailssApplication.class, args);
	}
	

}
