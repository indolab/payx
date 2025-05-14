package com.example.payx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.payx.models.User;
import com.example.payx.services.UserService;
import com.example.payx.models.Transaction;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(Model model) {
    // Fetch the current user from the service
    User currentUser = userService.getCurrentUser();

    // ✅ Pass user ID to getUserTransactions
    List<Transaction> transactions = userService.getUserTransactions(currentUser.getId());

    model.addAttribute("user", currentUser);
    model.addAttribute("transactions", transactions);

    return "profile";
}


    // Method to handle transactions from the front-end
    @GetMapping("/transaction")
    public String makeTransaction(@RequestParam Long receiverId, @RequestParam Integer amount, Model model) {
        boolean isSuccessful = userService.upipayment(receiverId, amount);

        if (isSuccessful) {
            model.addAttribute("message", "Transaction successful");
        } else {
            model.addAttribute("message", "Transaction failed");
        }

        return "redirect:/profile"; // Redirect back to profile after transaction
    }
    @PostMapping("/profile/send")
    public String sendMoney(@RequestParam Long receiverId, @RequestParam Integer amount, Model model) {
        boolean success = userService.upipayment(receiverId, amount);
    
        User currentUser = userService.getCurrentUser();
        List<Transaction> transactions = userService.getUserTransactions(currentUser.getId());
    
        model.addAttribute("user", currentUser);
        model.addAttribute("transactions", transactions);
        model.addAttribute("message", success ? "Payment successful!" : "Payment failed. Check balance or receiver ID.");
    
        return "profile";
    }
    

    // Optionally, you can also add a logout method
    @GetMapping("/logout")
    public String logout(Model model) {
        // Reset the current user (perhaps clearing the session, or setting `curr` to null)
        userService.logout();
        model.addAttribute("message", "You have logged out.");
        return "redirect:/login"; // Redirect to login page after logout
    }
}
