package com.example.twitterapi.controller;

import com.example.twitterapi.model.FollowRequest;
import com.example.twitterapi.model.Post;
import com.example.twitterapi.model.PostRequest;
import com.example.twitterapi.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TwitterServiceController {
    Map<User, List<Post>> userPostHashMap = new HashMap<>();

    @GetMapping("/api")
    public String test(){
        return "Hello";
    }

    @PostMapping("/postTweet")
    public void createPost(@RequestBody PostRequest postRequest){
        User user = postRequest.getUser();
        Post post = postRequest.getPost();

        post.setCreatedAt(System.currentTimeMillis());
        post.setUserCreator(user);

        // DAO saves the post in db
        userPostHashMap.putIfAbsent(user, new ArrayList<>());
        userPostHashMap.get(user).add(post);
    }

    @PostMapping("/followUser")
    public void followUser(@RequestBody FollowRequest followRequest){
        User followee = followRequest.getFollowee();
        User following = followRequest.getFollowing();

        followee.getFollowing().add(following);
        following.getFollowers().add(followee);
    }

    @PostMapping("/getTimeline")
    public List<Post> fetchTimeline(@RequestBody User user){
        List<User> followList = user.getFollowing();
        List<Post> postList = new ArrayList<>();

        for(User followingUser : followList){
            List<Post> posts = userPostHashMap.get(followingUser);
            if (posts != null) {
                postList.addAll(posts);
            }
        }
        postList.sort((a, b) -> Long.compare(b.getCreatedAt(), a.getCreatedAt()));
        return postList;
    }
}