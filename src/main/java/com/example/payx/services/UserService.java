package com.example.payx.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payx.Repositories.UserRepo;
import com.example.payx.Repositories.TransactionRepo;
import com.example.payx.models.User;
import com.example.payx.models.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    private String curr;

    public void registerUser(User user) {
        user.setBalance(100); // Default balance for new users
        userRepo.save(user);
    }

    public User getCurrentUser() {
        return userRepo.findByEmail(curr).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean authUser(String email, String password) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getpassword().equals(password)) {
            curr = email;
            return true;
        }
        return false;
    }

    public boolean upipayment(Long receiverId, Integer bal) {
        Optional<User> senderOpt = userRepo.findByEmail(curr);
        User sender = senderOpt.orElseThrow(() -> new RuntimeException("Sender not found"));
        int senderCurrBal = sender.getBalance();
    
        Optional<User> receiverOpt = userRepo.findById(receiverId);
    
        if (senderCurrBal >= bal && receiverOpt.isPresent()) {
            User receiver = receiverOpt.get();
    
            // Perform the transfer
            sender.setBalance(senderCurrBal - bal);
            receiver.setBalance(receiver.getBalance() + bal);
    
            userRepo.save(sender);
            userRepo.save(receiver);
    
            // ✅ Record the transaction
            Transaction transaction = new Transaction();
            transaction.setSender(sender);
            transaction.setReceiver(receiver);
            transaction.setAmount(bal);
            transaction.setTimestamp(LocalDateTime.now());
            transaction.setStatus("Success");
            transaction.setType("Debit"); // sender's view is debit
    
            transactionRepo.save(transaction);
    
            return true;
        } else {
            System.out.println("Sender has insufficient balance or receiver not found.");
            return false;
        }
    }
    

    // Get all transactions for the current user (both sender and receiver)
    public List<Transaction> getUserTransactions(Long userID) {
        

        // Fetch transactions by sender or receiver
        List<Transaction> sentTransactions = transactionRepo.findBySenderId(userID);
        List<Transaction> receivedTransactions = transactionRepo.findByReceiverId(userID);

        // Combine both lists
        sentTransactions.addAll(receivedTransactions);

    

        return sentTransactions;
    }

    // Optionally, a logout function to clear the current user session
    public void logout() {
        this.curr = null;
    }
}
