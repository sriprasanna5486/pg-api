package com.pgmanagement.service;

import com.pgmanagement.dto.*;
import com.pgmanagement.model.*;
import com.pgmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TenantRepository tenantRepo;

    // LOGIN
    public ApiResponse login(LoginRequest req) {

        Optional<User> userOpt =
            userRepo.findByEmailAndPassword(
                req.getEmail(),
                req.getPassword()
            );

        if (userOpt.isEmpty()) {
            return new ApiResponse(
                false, "Invalid email or password!"
            );
        }

        User user = userOpt.get();

        // Only tenants can use mobile app
        if (!"TENANT".equals(user.getRole())) {
            return new ApiResponse(
                false,
                "Owner must use the desktop app!"
            );
        }

        return new ApiResponse(
            true, "Login successful!", user
        );
    }

    // REGISTER
    public ApiResponse register(RegisterRequest req) {

        // Check email exists
        if (userRepo.existsByEmail(req.getEmail())) {
            return new ApiResponse(
                false, "Email already registered!"
            );
        }

        // Create user
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setPhone(req.getPhone());
        user.setRole("TENANT");

        userRepo.save(user);

        return new ApiResponse(
            true,
            "Registration successful! Please login."
        );
    }
}