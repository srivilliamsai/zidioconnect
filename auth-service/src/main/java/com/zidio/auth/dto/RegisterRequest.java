package com.zidio.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterRequest {
    @Email @NotBlank @Size(max=120)
    private String email;

    @NotBlank @Size(min=6, max=120)
    private String password;

    @NotBlank @Size(max=120)
    private String fullName;

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}