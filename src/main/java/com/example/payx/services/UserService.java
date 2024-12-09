package com.example.payx.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payx.Repositories.UserRepo;
import com.example.payx.models.User;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private User user ;

    //private Integer pool = 1000;
    
    private String curr;

    public void registeruser(User user){
        
        
        user.setBalance(100);
       
        userRepo.save(user);
    }
    public User getCurrentUser(){
        user = userRepo.findByEmail(curr);
       
        return user;

    }
    public boolean authuser(String email,String password){
        user = userRepo.findByEmail(email);
        if(user !=null &&user.getpassword(email).equals(password)){
            curr =email;
            return true;
        }
        else{
            return false;
        }

    }
   
}
