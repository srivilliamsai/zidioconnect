package com.zidio.zidioconnect.dto;

import com.zidio.zidioconnect.enums.Role;

public class SystemUserDTO {

    public Long id;
    public String name;
    public String email;
    public String password;
    public Role role;
    public boolean isActive;

    public SystemUserDTO() {}

    public SystemUserDTO(Long id, String name, String email, String password, Role role, boolean isActive) {
       
    	this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
        
    }
}
