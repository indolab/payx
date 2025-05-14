package com.example.payx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.payx.services.UserService;





@Controller
public class LoginController {
   @Autowired
   UserService usersr;
   
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Assuming your login view is named 'login.html'
    }

   @PostMapping("/login")
public String login(@RequestParam String email, @RequestParam String password, Model model) {
    if (usersr.authUser(email, password)) {
        // Set the user in the session or authentication context
        return "redirect:/profile"; // Redirect to profile on successful login
    } else {
        model.addAttribute("error", "Invalid credentials. Please try again.");
        return "login"; // Stay on login page if authentication fails
    }
}
   

    
}
