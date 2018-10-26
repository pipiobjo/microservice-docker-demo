package com.pipiobjo.microservice.helloWorldApp.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Greeting {

    private final long id;
    private final String content;

}
