package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.JobPostDTO;
import java.util.List;

public interface JobPostService {
    JobPostDTO createJobPost(JobPostDTO jobPostDTO);
    JobPostDTO getJobPostById(Long id);
    List<JobPostDTO> getAllJobPosts();
    void deleteJobPost(Long id);
    JobPostDTO updateJobPost(Long id, JobPostDTO updatedPost);
}
