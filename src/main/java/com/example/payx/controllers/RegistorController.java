package com.example.payx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.payx.models.User;
import com.example.payx.services.UserService;


@Controller
public class RegistorController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String getMethodName() {
        return "register";
    }
    @PostMapping("/register")
    public String postMethodName(@ModelAttribute User user) {
        userService.registeruser(user);
        
        return "login";
    }
    
    
}
