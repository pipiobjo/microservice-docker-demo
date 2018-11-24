package com.pipiobjo.microservice.helloworld.rest.controllers;

import com.pipiobjo.microservice.helloworld.models.Greeting;
import com.pipiobjo.microservice.helloworld.services.GreetingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @ApiOperation(httpMethod = "GET",
            value = "Resource to get a Greeting",
            response = Greeting.class,
            nickname="getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Greeting Found"),
            @ApiResponse(code = 404, message = "Greeting not found")
    })
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false) String name) {
        log.info("Starting request with name: {}", name);
        return greetingService.buildGreeting(name);
    }
}
