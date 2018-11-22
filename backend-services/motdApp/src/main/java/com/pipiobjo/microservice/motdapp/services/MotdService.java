package com.pipiobjo.microservice.motdapp.services;

import com.pipiobjo.microservice.motdapp.services.models.Motd;
import com.pipiobjo.microservice.motdapp.repository.ThoughtRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class MotdService {
    private final AtomicLong counter = new AtomicLong();
    private Motd msg;
    private ThoughtRepository repository;

    @Autowired
    public MotdService(ThoughtRepository repository){
        this.repository = repository;

    }

    /**
     * Get the actual motd
     * @return
     */
    @Cacheable("motd")
    public Motd getMotd(){
           return this.msg;
    }


    /**
     * Force recreating motd
     */
    @CacheEvict(allEntries = true, value = {"motd"})
    @Scheduled(fixedDelayString = "${motd.creationIntervall}")
    public Motd buildNewMotd(){

        this.msg = Motd.builder().id(counter.incrementAndGet()).timestamp(LocalTime.now()).content(repository.getRandomQuote()).build();
        log.info("New Quote generated {} ", this.msg);
        return this.msg;
    }
}
