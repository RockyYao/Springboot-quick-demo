package com.springboot.blockq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BlockqApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockqApplication.class, args);
	}
}
