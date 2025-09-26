package com.zidio.systemuser.mapper;

import com.zidio.systemuser.dto.CreateUserDTO;
import com.zidio.systemuser.dto.UpdateUserDTO;
import com.zidio.systemuser.dto.UserDTO;
import com.zidio.systemuser.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User e) {
        if (e == null) return null;
        UserDTO d = new UserDTO();
        d.setId(e.getId());
        d.setUsername(e.getUsername());
        d.setEmail(e.getEmail());
        d.setRole(e.getRole());
        d.setContactNumber(e.getContactNumber());
        d.setProfileImageUrl(e.getProfileImageUrl());
        d.setActive(e.isActive());
        d.setBlocked(e.isBlocked());
        d.setDeleted(e.isDeleted());
        d.setCreatedAt(e.getCreatedAt());
        d.setUpdatedAt(e.getUpdatedAt());
        return d;
    }

    public static User fromCreate(User e, CreateUserDTO d, String passwordHash) {
        e.setUsername(d.getUsername());
        e.setEmail(d.getEmail());
        e.setPasswordHash(passwordHash);
        if (d.getRole() != null) e.setRole(d.getRole());
        e.setContactNumber(d.getContactNumber());
        e.setProfileImageUrl(d.getProfileImageUrl());
        return e;
    }

    public static void applyUpdate(User e, UpdateUserDTO d) {
        if (d.getEmail() != null) e.setEmail(d.getEmail());
        if (d.getContactNumber() != null) e.setContactNumber(d.getContactNumber());
        if (d.getProfileImageUrl() != null) e.setProfileImageUrl(d.getProfileImageUrl());
        if (d.getRole() != null) e.setRole(d.getRole());
        if (d.getActive() != null) e.setActive(d.getActive());
        if (d.getBlocked() != null) e.setBlocked(d.getBlocked());
        if (d.getDeleted() != null) e.setDeleted(d.getDeleted());
    }
}
