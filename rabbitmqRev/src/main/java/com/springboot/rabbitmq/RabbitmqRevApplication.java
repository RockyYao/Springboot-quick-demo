package com.springboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.Lock;

@EnableRabbit
@SpringBootApplication

public class RabbitmqRevApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqRevApplication.class, args);
	}
}
