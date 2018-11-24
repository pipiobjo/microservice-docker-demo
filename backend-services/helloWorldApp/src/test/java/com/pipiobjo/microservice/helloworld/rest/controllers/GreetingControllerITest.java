package com.pipiobjo.microservice.helloworld.rest.controllers;

import com.pipiobjo.microservice.helloworld.HelloWorldAppApplication;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloWorldAppApplication.class},webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingControllerITest {

    @LocalServerPort
    private int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	public void contextLoads() {
		get("/greeting").then().body("id", equalTo(1));
	}

}
