package com.example.payx.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payx.models.User;



/**
 * UserRepo
 */
public interface UserRepo extends JpaRepository<User, Integer> {
User findByEmail(String email);
}
