package com.example.payx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Correct import for Model
import org.springframework.web.bind.annotation.GetMapping;

import com.example.payx.models.User;
import com.example.payx.services.UserService;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(Model model) {
        // Fetch the current user from the service
        User currentUser = userService.getCurrentUser();
        
        // Add the user data to the model to pass it to the view
        model.addAttribute("user", currentUser);

        // Return the name of the view (e.g., "profile.html" in your templates folder)
        return "profile"; // Replace with the actual name of your profile HTML view
    }
}
