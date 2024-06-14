package com.example.twitterapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowRequest {
    private User followee;
    private User following;
}
