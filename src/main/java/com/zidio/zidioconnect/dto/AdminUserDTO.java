package com.zidio.zidioconnect.dto;

import com.zidio.zidioconnect.enums.Role;

public class AdminUserDTO {
    private Long id;
    private String name;
    private String email;
    private String username;
    private Role role;
    private boolean active;
    private boolean blocked;

    // Constructors
    public AdminUserDTO() {}

    public AdminUserDTO(Long id, String name, String email, String username, Role role, boolean active, boolean blocked) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.role = role;
        this.active = active;
        this.blocked = blocked;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public boolean isBlocked() { return blocked; }
    public void setBlocked(boolean blocked) { this.blocked = blocked; }
}
