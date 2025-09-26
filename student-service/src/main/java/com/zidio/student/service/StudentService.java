package com.zidio.student.service;

import com.zidio.student.dto.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface StudentService {
    StudentDTO create(StudentDTO dto);
    StudentDTO get(Long id);
    Page<StudentDTO> list(Pageable pageable);
    StudentDTO update(Long id, StudentDTO dto);
    void delete(Long id);
}
