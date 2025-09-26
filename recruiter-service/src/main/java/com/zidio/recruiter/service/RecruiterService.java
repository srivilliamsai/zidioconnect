package com.zidio.recruiter.service;

import com.zidio.recruiter.dto.RecruiterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecruiterService {
    RecruiterDTO create(RecruiterDTO dto);
    RecruiterDTO get(Long id);
    Page<RecruiterDTO> list(String q, Pageable pageable);
    RecruiterDTO update(Long id, RecruiterDTO dto);
    void delete(Long id);
}
