package com.pgmanagement.controller;

import com.pgmanagement.dto.*;
import com.pgmanagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    // POST /api/auth/login
    @PostMapping("/login")
    public ApiResponse login(
            @RequestBody LoginRequest req) {
        return authService.login(req);
    }

    // POST /api/auth/register
    @PostMapping("/register")
    public ApiResponse register(
            @RequestBody RegisterRequest req) {
        return authService.register(req);
    }
}