package com.pipiobjo.microservice.motdapp.services.models;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
public class Motd {

    private long id;
    private String content;
    private Timestamp timestamp;

}
