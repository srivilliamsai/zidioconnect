package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.AuthResponse;
import com.zidio.zidioconnect.dto.LoginRequest;
import com.zidio.zidioconnect.dto.RegisterRequest;
import com.zidio.zidioconnect.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
}
