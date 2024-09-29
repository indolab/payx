package com.example.payx.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payx.Repositories.UserRepo;
import com.example.payx.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private User user ;

    public void registeruser(User user){
        userRepo.save(user);
    }
    public boolean authuser(String email,String password){
        User user = userRepo.findByEmail(email);
        return user !=null &&user.getpassword(email).equals(password);

    }
    public User getCurrentUser() {
        // Get the authentication object from the security context
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername(); // Get the username (email)
            return userRepo.findByEmail(email); // Find the user by email
        }
        return null; // User is not authenticated
    }
}
