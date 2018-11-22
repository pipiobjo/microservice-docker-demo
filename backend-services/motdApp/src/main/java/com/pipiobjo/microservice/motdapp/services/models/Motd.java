package com.pipiobjo.microservice.motdapp.services.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Motd {

    private final long id;
    private final String content;

}
