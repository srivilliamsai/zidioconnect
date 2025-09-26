package com.zidio.jobpost.service;

import com.zidio.jobpost.dto.JobPostDTO;
import com.zidio.jobpost.enums.JobStatus;
import com.zidio.jobpost.enums.JobType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobPostService {
    JobPostDTO create(JobPostDTO dto);
    JobPostDTO get(Long id);
    JobPostDTO update(Long id, JobPostDTO dto);
    void delete(Long id);
    Page<JobPostDTO> list(String q, Pageable pageable);
    List<JobPostDTO> listByStatus(JobStatus status);
    List<JobPostDTO> listByType(JobType type);
    List<JobPostDTO> searchCompany(String company);
}