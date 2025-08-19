package com.CounsellorPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MiniProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(MiniProject1Application.class, args);
	}

}
