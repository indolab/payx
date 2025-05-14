package com.example.payx.Repositories;

import com.example.payx.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    // Use Optional to handle cases where no user is found
    Optional<User> findByEmail(String email);
}
