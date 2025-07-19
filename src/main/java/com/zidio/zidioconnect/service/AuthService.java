package com.zidio.zidioconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.dto.AuthResponse;
import com.zidio.zidioconnect.dto.LoginRequest;
import com.zidio.zidioconnect.dto.RegisterRequest;
import com.zidio.zidioconnect.entity.SystemUser;
import com.zidio.zidioconnect.enums.Role;
import com.zidio.zidioconnect.repository.SystemUserRepository;
import com.zidio.zidioconnect.security.JWTUtil;

@Service
public class AuthService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    public AuthResponse register(RegisterRequest request) {
        SystemUser user = new SystemUser();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setRole(request.role != null ? request.role : Role.STUDENT); // default role
        user.setActive(true); // new users are active by default

        systemUserRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token, "User Registered Successfully");
    }

    public AuthResponse login(LoginRequest request) {
        SystemUser user = systemUserRepository.findByEmail(request.email)
            .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        if (!user.isActive()) {
            throw new RuntimeException("Account is deactivated");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token, "Login Successful");
    }
}