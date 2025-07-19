package com.zidio.zidioconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.zidioconnect.entity.JobPost;
import com.zidio.zidioconnect.enums.JobType;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    List<JobPost> findByPostedByEmail(String email);

    List<JobPost> findByJobTitle(String jobTitle);

    List<JobPost> findByJobType(JobType jobType);

    List<JobPost> findByCompanyName(String companyName);
}

