package com.zidio.zidioconnect.dto;

import com.zidio.zidioconnect.enums.Role;

public class AdminUserDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private boolean active;
    private boolean blocked;
    
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Role getRole() {
		return role;
	}
	public boolean isActive() {
		return active;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
    
}