package com.pipiobjo.microservice.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Serviceregistry {

	public static void main(String[] args) {
		SpringApplication.run(Serviceregistry.class, args);
	}
}
