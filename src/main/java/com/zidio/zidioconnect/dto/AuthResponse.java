package com.zidio.zidioconnect.dto;

import com.zidio.zidioconnect.enums.Role;

public class AuthResponse {

    private String token;
    private String message;

    // ✅ Added fields
    private Long userId;
    private String email;
    private Role role;

    // ✅ Default constructor
    public AuthResponse() {}

    // ✅ Full-args constructor
    public AuthResponse(String token, String message, Long userId, String email, Role role) {
        this.token = token;
        this.message = message;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // ✅ Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
