package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.AuthResponse;
import com.zidio.zidioconnect.dto.RegisterRequest;
import com.zidio.zidioconnect.dto.SystemUserDTO;
import com.zidio.zidioconnect.entity.SystemUser;
import com.zidio.zidioconnect.enums.Role;
import com.zidio.zidioconnect.enums.PaidStatus;
import com.zidio.zidioconnect.repository.SystemUserRepository;
import com.zidio.zidioconnect.security.JwtUtil;
import com.zidio.zidioconnect.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public AuthResponse login(String email, String password) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );

        SystemUser user = systemUserRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(email);

        return new AuthResponse(
            token,
            "Login successful",
            user.getId(),
            user.getEmail(),
            user.getRole()
        );
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (systemUserRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        SystemUser user = new SystemUser();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : Role.STUDENT);
        user.setPaidStatus(PaidStatus.UNPAID); // default
        user.setEnabled(true);

        systemUserRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(
            token,
            "User registered successfully",
            user.getId(),
            user.getEmail(),
            user.getRole()
        );
    }

	@Override
	public AuthResponse register(SystemUserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
