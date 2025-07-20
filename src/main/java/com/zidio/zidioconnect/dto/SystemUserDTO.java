package com.zidio.zidioconnect.dto;

import com.zidio.zidioconnect.enums.PaidStatus;
import com.zidio.zidioconnect.enums.Role;

public class SystemUserDTO {

    private Long id;
    private String name;
    private String email;
    private String password; // ✅ Needed for registration/login
    private Role role;
    private PaidStatus paidStatus;
    private boolean active;

    // ✅ Constructors
    public SystemUserDTO() {}

    public SystemUserDTO(Long id, String name, String email, Role role, PaidStatus paidStatus, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.paidStatus = paidStatus;
        this.active = active;
    }

    public SystemUserDTO(Long id, String name, String email, String password, Role role, PaidStatus paidStatus, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.paidStatus = paidStatus;
        this.active = active;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public PaidStatus getPaidStatus() { return paidStatus; }
    public void setPaidStatus(PaidStatus paidStatus) { this.paidStatus = paidStatus; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
