package com.example.twitterapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    String postId;
    String content;
    User userCreator;
    long createdAt;
}
