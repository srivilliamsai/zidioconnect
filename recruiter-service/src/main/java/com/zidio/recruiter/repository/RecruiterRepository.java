package com.zidio.recruiter.repository;

import com.zidio.recruiter.entity.Recruiter;
import com.zidio.recruiter.enums.RecruiterStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long>, JpaSpecificationExecutor<Recruiter> {
    Optional<Recruiter> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Recruiter> findByStatus(RecruiterStatus status);
}
