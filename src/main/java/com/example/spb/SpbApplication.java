package com.example.spb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbApplication.class, args);
	}

}
