package com.example.payx.dto;

public class PaymentRequest {
    private String service;
    private String serial;
    private Integer amount;
    private String paymentMode;

    public String getService() {
        return service;
    }

    public String getSerial() {
        return serial;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }
    public PaymentRequest(String service, String serial, Integer amount, String paymentMode) {
        this.service = service;
        this.serial = serial;
        this.amount = amount;
        this.paymentMode = paymentMode;
    }

// Getters and Setters
    public void setService(String service) {
        this.service = service;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
