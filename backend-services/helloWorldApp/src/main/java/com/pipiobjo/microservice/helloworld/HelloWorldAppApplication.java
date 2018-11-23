package com.pipiobjo.microservice.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloWorldAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldAppApplication.class, args);
	}
}
