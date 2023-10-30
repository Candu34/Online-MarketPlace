package com.example.onlinemarketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OnlineMarketPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMarketPlaceApplication.class, args);

	}


}
