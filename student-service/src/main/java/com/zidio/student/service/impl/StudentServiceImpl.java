package com.zidio.student.service.impl;

import com.zidio.student.dto.StudentDTO;
import com.zidio.student.entity.Student;
import com.zidio.student.mapper.StudentMapper;
import com.zidio.student.repository.StudentRepository;
import com.zidio.student.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap; 
import java.util.Map; 
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;
    private final Map<Long, StudentDTO> studentCache = new HashMap<>(); // 

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentDTO create(StudentDTO dto) {
        if (repo.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + dto.getEmail());
        }
        Student s = StudentMapper.toEntity(dto);
        s = repo.save(s);
        studentCache.clear();
        return StudentMapper.toDTO(s);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDTO get(Long id) {
        if (studentCache.containsKey(id)) {
            return studentCache.get(id);
        }

        Student s = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found: " + id));
        StudentDTO dto = StudentMapper.toDTO(s);

        studentCache.put(id, dto);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentDTO> list(Pageable pageable) {
        Page<Student> page = repo.findAll(pageable);
        return new PageImpl<>(
                page.getContent().stream().map(StudentMapper::toDTO).collect(Collectors.toList()),
                pageable,
                page.getTotalElements()
        );
    }

    @Override
    public StudentDTO update(Long id, StudentDTO dto) {
        Student s = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found: " + id));
        
        studentCache.remove(id); 

        if (dto.getEmail() != null && !dto.getEmail().equalsIgnoreCase(s.getEmail())) {
            if (repo.existsByEmail(dto.getEmail())) {
                throw new IllegalArgumentException("Email already exists: " + dto.getEmail());
            }
        }
        StudentMapper.copyToEntity(dto, s);
        s = repo.save(s);
        return StudentMapper.toDTO(s);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new RuntimeException("Student not found: " + id);
        repo.deleteById(id);
        studentCache.remove(id); 
    }
}