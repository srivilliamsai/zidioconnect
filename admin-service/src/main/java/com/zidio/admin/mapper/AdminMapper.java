package com.zidio.admin.mapper;

import com.zidio.admin.dto.AdminDTO;
import com.zidio.admin.entity.Admin;

public final class AdminMapper {

    private AdminMapper() {}

    public static AdminDTO toDTO(Admin a) {
        if (a == null) return null;
        AdminDTO dto = new AdminDTO();
        dto.setId(a.getId());
        dto.setFirstName(a.getFirstName());
        dto.setLastName(a.getLastName());
        dto.setEmail(a.getEmail());
        dto.setPhone(a.getPhone());
        dto.setContactNumber(a.getContactNumber());
        dto.setProfileImageUrl(a.getProfileImageUrl());
        dto.setActive(a.isActive());
        dto.setBlocked(a.isBlocked());
        dto.setDeleted(a.isDeleted());
        dto.setRole(a.getRole());
        dto.setStatus(a.getStatus());
        return dto;
    }

    public static Admin toEntity(AdminDTO dto) {
        if (dto == null) return null;
        Admin a = new Admin();
        a.setFirstName(dto.getFirstName());
        a.setLastName(dto.getLastName());
        a.setEmail(dto.getEmail());
        a.setPhone(dto.getPhone());
        a.setContactNumber(dto.getContactNumber());
        a.setProfileImageUrl(dto.getProfileImageUrl());
        if (dto.getActive() != null) a.setActive(dto.getActive());
        if (dto.getBlocked() != null) a.setBlocked(dto.getBlocked());
        if (dto.getDeleted() != null) a.setDeleted(dto.getDeleted());
        a.setRole(dto.getRole());
        a.setStatus(dto.getStatus());
        return a;
    }

    public static void copy(AdminDTO dto, Admin a) {
        if (dto.getFirstName() != null) a.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) a.setLastName(dto.getLastName());
        if (dto.getEmail() != null) a.setEmail(dto.getEmail());
        if (dto.getPhone() != null) a.setPhone(dto.getPhone());
        if (dto.getContactNumber() != null) a.setContactNumber(dto.getContactNumber());
        if (dto.getProfileImageUrl() != null) a.setProfileImageUrl(dto.getProfileImageUrl());
        if (dto.getActive() != null) a.setActive(dto.getActive());
        if (dto.getBlocked() != null) a.setBlocked(dto.getBlocked());
        if (dto.getDeleted() != null) a.setDeleted(dto.getDeleted());
        if (dto.getRole() != null) a.setRole(dto.getRole());
        if (dto.getStatus() != null) a.setStatus(dto.getStatus());
    }
}