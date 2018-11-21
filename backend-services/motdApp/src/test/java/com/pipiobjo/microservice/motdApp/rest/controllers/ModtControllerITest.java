package com.pipiobjo.microservice.motdApp.rest.controllers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static  org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ModtControllerITest {

    @LocalServerPort
    private int port;

	@Value("motd.creationIntervall")
	private static int delay;

	@Before
	public void setUp() {
		RestAssured.port = port;

	}

	@Test
	public void contextLoads() {
		get("/motd").then().body("id", not(equalTo(0)));
	}

	@Test
	public void testCache() throws InterruptedException {
		Response r = get("/motd");
		JsonPath jsonPath = r.jsonPath();
		String content = jsonPath.get("content");
		assertThat(content).isNotBlank();

		get("/motd").then().body("content", equalTo(content));
		get("/motd").then().body("id", equalTo(1));

//		Doing this way is of course not working ;-)
//		await().atLeast(5, SECONDS);
//		get("/motd").then().body("content", not(equalTo(content)));

		await().atLeast(delay, MILLISECONDS).untilAsserted(() -> get("/motd").then().body("content", not(equalTo(content))));

	}

}
