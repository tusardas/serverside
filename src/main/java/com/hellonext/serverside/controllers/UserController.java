package com.hellonext.serverside.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.hellonext.serverside.services.UserService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public String postMethodName(@RequestBody String jsonBody) {
        JSONObject json = new JSONObject(jsonBody);
        String email = json.getString("email");
        String password = json.getString("password");
        String result = userService.getUserByEmailAndPassword(email, password);
        return result;
    }
    
}
