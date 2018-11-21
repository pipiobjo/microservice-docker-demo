package com.pipiobjo.microservice.motdApp.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.pipiobjo.microservice.motdApp.repository.model.Thought;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ThoughtRepository {
private static final Gson gson = new Gson();
private static final Random random = new Random();
private Type listType = new TypeToken<ArrayList<Thought>>(){}.getType();
    private int idx= -1;

    public String getRandomQuote (){
        List<Thought> data = readThoughtsFromFile();

        this.idx = new Random().nextInt(data.size());
        return data.get(idx).getQuote();
    }


    public String getQuoteByNumber (int idx){
        //@TODO parameter validation
        List<Thought> data = readThoughtsFromFile();
        return data.get(idx).getQuote();
    }


    private List<Thought> readThoughtsFromFile() {
        final InputStream is = this.getClass().getClassLoader().getResourceAsStream("json/thought.json");
        JsonReader reader = new JsonReader(new InputStreamReader(is));
        return gson.fromJson(reader, listType);
    }

    int generateRandom(int lastRandomNumber, int maxValue) {

        // add-and-wrap another random number to produce a guaranteed
        // different result.
        // note the one-less-than UPPER_BOUND input
        int rotate = 1 + random.nextInt(maxValue - 1);
        // 'rotate' the last number
        return (lastRandomNumber + rotate) % maxValue;

    }
}
