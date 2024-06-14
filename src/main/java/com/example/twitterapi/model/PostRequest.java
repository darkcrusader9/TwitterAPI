package com.example.twitterapi.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private User user;
    private Post post;
}