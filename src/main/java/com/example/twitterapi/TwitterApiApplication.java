package com.example.twitterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwitterApiApplication.class, args);
        /*
            1. Create a POST
            2. Follow a user
            3. Fetch news feed from list of followers
         */
    }

}
