package com.zidio.jobpost.repository;

import com.zidio.jobpost.entity.JobPost;
import com.zidio.jobpost.enums.JobStatus;
import com.zidio.jobpost.enums.JobType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    List<JobPost> findByStatus(JobStatus status);
    List<JobPost> findByJobType(JobType type);
    List<JobPost> findByCompanyContainingIgnoreCase(String company);

    // This method is required for search functionality
    Page<JobPost> findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCase(String title, String company, Pageable pageable);
}