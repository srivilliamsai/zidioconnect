package com.zidio.auth.service;

import com.zidio.auth.entity.User;
import com.zidio.auth.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return org.springframework.security.core.userdetails.User
                .withUsername(u.getEmail())
                .password(u.getPassword())   // MUST be encoded in DB
                .authorities(
                        u.getRoles().stream()
                                .map(r -> r.getName().name()) // ROLE_STUDENT, ROLE_ADMIN, etc.
                                .toArray(String[]::new)
                )
                .accountLocked(u.isBlocked())
                .disabled(u.isDeleted())
                .build();
    }
}