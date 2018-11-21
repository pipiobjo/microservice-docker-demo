package com.pipiobjo.microservice.motdApp.repository.model;

import lombok.Data;

@Data
public class Thought {
    private ThoughtThemes[] thoughtThemes;

    private String visible;

    private String quote;

    private ThoughtAuthor thoughtAuthor;

    private String shortUri;

    private String naturalId;

    private String quoteFragment;

    private String uri;
}
