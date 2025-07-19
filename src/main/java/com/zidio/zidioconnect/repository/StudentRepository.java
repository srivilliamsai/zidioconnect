package com.zidio.zidioconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.zidioconnect.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByEmail(String email);
    List<Student> findByNameContaining(String name);
    List<Student> findByQualification(String qualification);
}