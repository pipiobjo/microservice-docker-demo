package com.pipiobjo.microservice.motdapp.rest.controllers;

import com.pipiobjo.microservice.motdapp.MainApplication;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static  org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
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
        int id = jsonPath.get("id");
        String timestamp = jsonPath.getString("timestamp");
        assertThat(timestamp).isNotBlank();


		get("/motd").then().body("content", equalTo(content), "id", equalTo(id));

//		Doing this way is of course not working ;-)
//		await().atLeast(5, SECONDS);
//		get("/motd").then().body("content", not(equalTo(content)));

		await().atLeast(delay+100, MILLISECONDS).untilAsserted(() -> get("/motd").then().body("id", not(equalTo(id))));

	}

}
