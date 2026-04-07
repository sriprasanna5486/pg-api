package com.pgmanagement.repository;

import com.pgmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(
        String email, String password
    );

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}