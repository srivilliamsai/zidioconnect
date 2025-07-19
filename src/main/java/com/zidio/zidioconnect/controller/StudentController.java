package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.StudentDTO;
import com.zidio.zidioconnect.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/search/email")
    public List<StudentDTO> searchByEmail(@RequestParam String email) {
        return studentService.searchByEmail(email);
    }

    @GetMapping("/search/name")
    public List<StudentDTO> searchByName(@RequestParam String name) {
        return studentService.searchByName(name);
    }

    @GetMapping("/search/qualification")
    public List<StudentDTO> searchByQualification(@RequestParam String qualification) {
        return studentService.searchByQualification(qualification);
    }
}