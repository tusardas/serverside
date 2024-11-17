package com.hellonext.serverside.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.hellonext.serverside.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public String findById(@PathVariable Long id) {
        String response = postService.findById(id);
        return response;
    }
    
    @GetMapping("/post")
    public String findAll() {
        String response = postService.findAll();
        return response;
    }

    
}
