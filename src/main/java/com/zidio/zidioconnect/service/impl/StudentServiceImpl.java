package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.StudentDTO;
import com.zidio.zidioconnect.entity.Student;
import com.zidio.zidioconnect.repository.StudentRepository;
import com.zidio.zidioconnect.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
            student.getId(),
            student.getName(),
            student.getEmail(),
            student.getPhone(),
            student.getQualification(),
            student.getResumeURL(),
            student.getAddress(),
            student.getLinkedInProfile()
        );
    }

    private Student mapToEntity(StudentDTO dto) {
        return new Student(
            dto.getId(),
            dto.getName(),
            dto.getEmail(),
            dto.getPhone(),
            dto.getQualification(),
            dto.getResumeURL(),
            dto.getAddress(),
            dto.getLinkedInProfile()
        );
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentRepository.save(mapToEntity(studentDTO));
        return mapToDTO(student);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> searchByEmail(String email) {
        return studentRepository.findByEmail(email).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> searchByName(String name) {
        return studentRepository.findByNameContaining(name).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> searchByQualification(String qualification) {
        return studentRepository.findByQualification(qualification).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}