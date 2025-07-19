package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    List<StudentDTO> searchByEmail(String email);
    List<StudentDTO> searchByName(String name);
    List<StudentDTO> searchByQualification(String qualification);
}