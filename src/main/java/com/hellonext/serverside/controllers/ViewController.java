package com.hellonext.serverside.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hellonext.serverside.services.PostService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ViewController {
    
    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "view-all-posts";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/admin")
    public String viewAdminPage(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "admin-all-posts";
    }
}
