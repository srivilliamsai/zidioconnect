package com.zidio.auth.service;

import com.zidio.auth.dto.AuthResponse;
import com.zidio.auth.dto.LoginRequest;
import com.zidio.auth.dto.RegisterRequest;
import com.zidio.auth.entity.Role;
import com.zidio.auth.entity.User;
import com.zidio.auth.enums.RoleName;
import com.zidio.auth.repository.RoleRepository;
import com.zidio.auth.repository.UserRepository;
import com.zidio.auth.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwt;

    public AuthService(UserRepository userRepo, RoleRepository roleRepo,
                       PasswordEncoder encoder, AuthenticationManager authManager, JwtUtil jwt) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwt = jwt;
    }

    // ============================= REGISTER =============================
    @Transactional
    public AuthResponse register(RegisterRequest req, RoleName defaultRole) {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        User u = new User();
        u.setEmail(req.getEmail());
        u.setFullName(req.getFullName());
        u.setPassword(encoder.encode(req.getPassword()));
        Role role = roleRepo.findByName(defaultRole)
                .orElseGet(() -> roleRepo.save(new Role(defaultRole)));
        u.setRoles(Collections.singleton(role));

        userRepo.save(u);

        // Corrected: Pass the roles to generateToken
        List<String> roles = u.getRoles().stream().map(r -> r.getName().name()).collect(Collectors.toList());
        String token = jwt.generateToken(u.getEmail(), roles);

        return new AuthResponse(
                token,
                u.getEmail(),
                u.getFullName(),
                u.getRoles().stream().map(r -> r.getName().name()).collect(Collectors.toSet())
        );
    }

    // ============================= LOGIN =============================
    public AuthResponse login(LoginRequest req) {
        // Authenticate raw email + password
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        // Get authenticated user details
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        // Fetch full user entity (for roles/fullName/etc.)
        User u = userRepo.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found after authentication"));

        // Corrected: Pass the roles to generateToken
        List<String> roles = u.getRoles().stream().map(r -> r.getName().name()).collect(Collectors.toList());
        String token = jwt.generateToken(u.getEmail(), roles);

        return new AuthResponse(
                token,
                u.getEmail(),
                u.getFullName(),
                u.getRoles().stream().map(r -> r.getName().name()).collect(Collectors.toSet())
        );
    }
}