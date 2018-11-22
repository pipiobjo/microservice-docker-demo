package com.pipiobjo.microservice.motdApp.repository;

import org.junit.Test;
import java.net.URL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class ThoughtRepositoryTest {

    @Test
    public void testRepoCall(){

        final URL resource = this.getClass().getClassLoader().getResource("json/thought.json");
        assertThat(resource).isNotNull();
        ThoughtRepository repo = new ThoughtRepository();
        final String quote = repo.getQuoteByNumber(0);
        assertThat(quote).isNotBlank();
        assertThat(quote).isEqualTo("  Teach self-denial and make its practice pleasure, and you can create for the world a destiny more sublime that ever issued from the brain of the wildest dreamer.");

    }

    @Test
    public void testRandomRepoCall(){

        final URL resource = this.getClass().getClassLoader().getResource("json/thought.json");
        assertThat(resource).isNotNull();
        ThoughtRepository repo = new ThoughtRepository();
        final String quote = repo.getRandomQuote();
        assertThat(quote).isNotBlank();

        final String quote1 = repo.getRandomQuote();
        assertThat(quote1).isNotBlank();
        assertThat(quote).isNotEqualTo(quote1);

    }
}
