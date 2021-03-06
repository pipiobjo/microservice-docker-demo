package com.pipiobjo.microservice.helloWorldApp.services;

import com.pipiobjo.microservice.helloWorldApp.models.Greeting;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

/**
 * GreetingService needs no spring context so simply test the service logic
 */
public class GreetingServiceTest {
    private GreetingService gs = new GreetingService();

    @Test
    public void buildGreeting() {
        String name = "john";
        Greeting greeting = gs.buildGreeting(name);
        assertThat(greeting.getId()).isEqualTo(1);
        assertThat(greeting.getContent()).contains(name);

        Greeting second_greeting = gs.buildGreeting(name);
        assertThat(second_greeting.getId()).isEqualTo(2);

        Greeting nullname_greeting = gs.buildGreeting(null);
        assertThat(nullname_greeting.getContent()).contains(GreetingService.GREETING_DEFAULT_VALUE);
    }
}