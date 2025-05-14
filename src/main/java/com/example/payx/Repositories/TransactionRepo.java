package com.example.payx.Repositories;

import com.example.payx.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    // Find transactions by sender
    List<Transaction> findBySenderId(Long senderId);

    // Find transactions by receiver
    List<Transaction> findByReceiverId(Long receiverId);
    
}
