package com.pipiobjo.microservice.motdapp.services.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class Motd {

    private long id;
    private String content;
    private LocalTime timestamp;

}
