package com.pipiobjo.microservice.helloWorldApp.rest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.pipiobjo.microservice.helloWorldApp.models.Greeting;
import com.pipiobjo.microservice.helloWorldApp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false) String name) {
        return greetingService.buildGreeting(name);
    }
}
