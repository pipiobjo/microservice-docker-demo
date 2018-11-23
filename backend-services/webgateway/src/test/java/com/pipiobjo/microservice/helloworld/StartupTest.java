package com.pipiobjo.microservice.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Simple test class to check application start
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
@SpringBootTest(classes = {WebgatewayApp.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StartupTest {

    @Value("${spring.application.name}")
    private String appName;

    @Test
    public void contextLoads(){
        assertThat(appName).isNotBlank();
        assertThat(appName).isEqualTo("webgateway");
    }
}
