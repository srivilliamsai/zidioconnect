package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.JobPostDTO;
import java.util.List;

public interface JobPostService {
    JobPostDTO createJobPost(JobPostDTO jobPostDTO);
    JobPostDTO getJobPostById(Long id);
    List<JobPostDTO> getAllJobPosts();
    JobPostDTO updateJobPost(Long id, JobPostDTO jobPostDTO);
    void deleteJobPost(Long id);
}