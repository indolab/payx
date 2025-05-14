package com.example.payx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.payx.dto.PaymentRequest;
import com.example.payx.services.UserService;


@Controller
public class MartControllers {
     @Autowired
    private UserService userService;
    @GetMapping("/mart")
    public String getMethodName(Model model) {
        return "mart";
    }
     @PostMapping("mart/pay")
    public ResponseEntity<String> handlePayment(@RequestBody PaymentRequest request,Model model) {
        System.out.println("Received payment: " + request);
        int k =102;
        Long myLongObject = Long.valueOf(k);
        long myLong = myLongObject; // Replace with actual receiver ID
        Integer amount = request.getAmount(); // Assuming the amount is in the request body
        userService.upipayment(myLong, amount);
        String type = request.getService();
        String status = "success"; // Replace with actual status
        userService.saveTransactiondir(amount,type,status,myLong);

    // Process logic here
    return ResponseEntity.ok("Payment received");
    }
    
}
