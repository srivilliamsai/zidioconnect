package com.zidio.recruiter.mapper;

import com.zidio.recruiter.dto.RecruiterDTO;
import com.zidio.recruiter.entity.Recruiter;

public class RecruiterMapper {

    public static Recruiter toEntity(RecruiterDTO dto) {
        if (dto == null) return null;
        Recruiter r = new Recruiter();
        r.setId(dto.getId());
        r.setFirstName(dto.getFirstName());
        r.setLastName(dto.getLastName());
        r.setEmail(dto.getEmail());
        r.setPhone(dto.getPhone());
        r.setCompany(dto.getCompany());
        r.setDesignation(dto.getDesignation());
        r.setLinkedInProfile(dto.getLinkedInProfile());
        r.setStatus(dto.getStatus());
        return r;
    }

    public static RecruiterDTO toDTO(Recruiter r) {
        if (r == null) return null;
        RecruiterDTO dto = new RecruiterDTO();
        dto.setId(r.getId());
        dto.setFirstName(r.getFirstName());
        dto.setLastName(r.getLastName());
        dto.setEmail(r.getEmail());
        dto.setPhone(r.getPhone());
        dto.setCompany(r.getCompany());
        dto.setDesignation(r.getDesignation());
        dto.setLinkedInProfile(r.getLinkedInProfile());
        dto.setStatus(r.getStatus());
        return dto;
    }

    public static void copyToEntity(RecruiterDTO dto, Recruiter r) {
        if (dto == null || r == null) return;
        r.setFirstName(dto.getFirstName());
        r.setLastName(dto.getLastName());
        r.setEmail(dto.getEmail());
        r.setPhone(dto.getPhone());
        r.setCompany(dto.getCompany());
        r.setDesignation(dto.getDesignation());
        r.setLinkedInProfile(dto.getLinkedInProfile());
        r.setStatus(dto.getStatus());
    }
}
