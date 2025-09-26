package com.zidio.student.mapper;

import com.zidio.student.dto.StudentDTO;
import com.zidio.student.entity.Student;

public final class StudentMapper {
    private StudentMapper() {}

    public static StudentDTO toDTO(Student s) {
        if (s == null) return null;
        StudentDTO dto = new StudentDTO();
        dto.setId(s.getId());
        dto.setFirstName(s.getFirstName());
        dto.setLastName(s.getLastName());
        dto.setEmail(s.getEmail());
        dto.setPhone(s.getPhone());
        dto.setQualification(s.getQualification());
        dto.setResumeURL(s.getResumeURL());
        dto.setAddress(s.getAddress());
        dto.setLinkedInProfile(s.getLinkedInProfile());
        dto.setStatus(s.getStatus());
        dto.setDateOfBirth(s.getDateOfBirth());
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        if (dto == null) return null;
        Student s = new Student();
        s.setId(dto.getId());
        s.setFirstName(dto.getFirstName());
        s.setLastName(dto.getLastName());
        s.setEmail(dto.getEmail());
        s.setPhone(dto.getPhone());
        s.setQualification(dto.getQualification());
        s.setResumeURL(dto.getResumeURL());
        s.setAddress(dto.getAddress());
        s.setLinkedInProfile(dto.getLinkedInProfile());
        s.setStatus(dto.getStatus());
        s.setDateOfBirth(dto.getDateOfBirth());
        return s;
    }

    public static void copyToEntity(StudentDTO dto, Student s) {
        if (dto == null || s == null) return;
        s.setFirstName(dto.getFirstName());
        s.setLastName(dto.getLastName());
        s.setEmail(dto.getEmail());
        s.setPhone(dto.getPhone());
        s.setQualification(dto.getQualification());
        s.setResumeURL(dto.getResumeURL());
        s.setAddress(dto.getAddress());
        s.setLinkedInProfile(dto.getLinkedInProfile());
        s.setStatus(dto.getStatus());
        s.setDateOfBirth(dto.getDateOfBirth());
    }
}
