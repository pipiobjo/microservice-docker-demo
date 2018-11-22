package com.pipiobjo.microservice.helloworldapp.services;

import com.pipiobjo.microservice.helloworldapp.models.Greeting;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class GreetingService {
    public static final String GREETING_DEFAULT_VALUE = "World";
    public static final String template = "Hello1, %s!";
    private final AtomicLong counter = new AtomicLong();

    public Greeting buildGreeting(String name){
        if(StringUtils.isBlank(name)){
            name = GREETING_DEFAULT_VALUE;
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
