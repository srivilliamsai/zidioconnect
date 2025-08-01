package com.zidio.zidioconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.zidioconnect.entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    Recruiter findByEmail(String email);

    List<Recruiter> findByCompanyNameContainingIgnoreCase(String companyName);
}