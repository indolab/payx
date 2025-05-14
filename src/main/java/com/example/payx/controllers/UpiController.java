/*package com.example.payx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.payx.services.UserService;


@Controller
public class UpiController {
    @Autowired
    UserService usrsr;
    @GetMapping("/upi")
    public String upipage() {
        return "upi";
    }
    
@PostMapping("/upi")
public String upimoney(@RequestParam Integer upiid ,@RequestParam Integer balance ) {
    usrsr.upipayment(upiid, balance);

    return "upi";
}

    
}
*/