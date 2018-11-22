package com.pipiobjo.microservice.motdapp.rest.controllers;

import com.pipiobjo.microservice.motdapp.services.models.Motd;
import com.pipiobjo.microservice.motdapp.services.MotdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotdController {

    @Autowired
    private MotdService motdService;


    @RequestMapping("/motd")
    public Motd greeting() {
        return motdService.getMotd();
    }
}
