package com.example.payx.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.payx.services.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequiredArgsConstructor
@Slf4j
public class PaypalController {
    @Autowired
    private PaypalService paypalService;

    @GetMapping("/pay")
    public String pay() {
        return "upi";
    }

    @PostMapping("/payment/create")
    public RedirectView createPayment() {
        try {
            String cancleURL = "http://localhost:8080/cancel";
            String successURL = "http://localhost:8080/success"; 
            Payment payment = paypalService.createPayment(
                100.0,
                "USD",
                "paypal",
                "sale",
                "payment description",
                cancleURL,
                successURL);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return new RedirectView(link.getHref());
                }
            }
            
        } catch (PayPalRESTException e) {
          // log.error("", e);
           
        }
        return new RedirectView("/upi");
        
    }

    
    

    
    
}
