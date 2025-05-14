package com.example.payx.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amount;
    private String type; // E.g., "UPI" or "Payment"
    private String status; // E.g., "Success" or "Failure"
    private LocalDateTime timestamp;
    
    @ManyToOne
    private User sender;
    
    @ManyToOne
    private User receiver;
    public Transaction() {}

    // Constructor to initialize sender, receiver, amount, and timestamp
    public Transaction(User sender, User receiver, Integer amount, String type, String status, LocalDateTime timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.timestamp = timestamp;
    }
    
    
    // Getters and Setters
    public Long getId() { return id; }
    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }
    public User getReceiver() { return receiver; }
    public void setReceiver(User receiver) { this.receiver = receiver; }
}
