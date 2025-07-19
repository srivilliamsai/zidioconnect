package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.JobPostDTO;
import com.zidio.zidioconnect.entity.JobPost;
import com.zidio.zidioconnect.repository.JobPostRepository;
import com.zidio.zidioconnect.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    private JobPostDTO convertToDTO(JobPost jobPost) {
        JobPostDTO dto = new JobPostDTO();
        dto.setId(jobPost.getId());
        dto.setJobTitle(jobPost.getJobTitle());
        dto.setJobDescription(jobPost.getJobDescription());
        dto.setJobLocation(jobPost.getJobLocation());
        dto.setJobType(jobPost.getJobType());
        dto.setCompanyName(jobPost.getCompanyName());
        dto.setPostedByEmail(jobPost.getPostedByEmail());
        dto.setPostedDate(jobPost.getPostedDate());
        dto.setMinSalary(jobPost.getMinSalary());
        dto.setMaxSalary(jobPost.getMaxSalary());
        dto.setMinExperience(jobPost.getMinExperience());
        dto.setMaxExperience(jobPost.getMaxExperience());
        dto.setJobStatus(jobPost.getJobStatus());
        dto.setLastDateToApply(jobPost.getLastDateToApply());
        return dto;
    }

    private JobPost convertToEntity(JobPostDTO dto) {
        JobPost jobPost = new JobPost();
        jobPost.setId(dto.getId());
        jobPost.setJobTitle(dto.getJobTitle());
        jobPost.setJobDescription(dto.getJobDescription());
        jobPost.setJobLocation(dto.getJobLocation());
        jobPost.setJobType(dto.getJobType());
        jobPost.setCompanyName(dto.getCompanyName());
        jobPost.setPostedByEmail(dto.getPostedByEmail());
        jobPost.setPostedDate(dto.getPostedDate());
        jobPost.setMinSalary(dto.getMinSalary());
        jobPost.setMaxSalary(dto.getMaxSalary());
        jobPost.setMinExperience(dto.getMinExperience());
        jobPost.setMaxExperience(dto.getMaxExperience());
        jobPost.setJobStatus(dto.getJobStatus());
        jobPost.setLastDateToApply(dto.getLastDateToApply());
        return jobPost;
    }

    @Override
    public JobPostDTO createJobPost(JobPostDTO dto) {
        return convertToDTO(jobPostRepository.save(convertToEntity(dto)));
    }

    @Override
    public JobPostDTO getJobPostById(Long id) {
        return jobPostRepository.findById(id)
            .map(this::convertToDTO)
            .orElseThrow(() -> new RuntimeException("JobPost not found with id: " + id));
    }

    @Override
    public List<JobPostDTO> getAllJobPosts() {
        return jobPostRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteJobPost(Long id) {
        jobPostRepository.deleteById(id);
    }

    @Override
    public JobPostDTO updateJobPost(Long id, JobPostDTO updatedPost) {
        JobPost existing = jobPostRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("JobPost not found"));
        JobPost updatedEntity = convertToEntity(updatedPost);
        updatedEntity.setId(existing.getId()); // Preserve original ID
        return convertToDTO(jobPostRepository.save(updatedEntity));
    }
}