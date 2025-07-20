package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.JobPostDTO;
import com.zidio.zidioconnect.entity.JobPost;
import com.zidio.zidioconnect.enums.JobStatus;
import com.zidio.zidioconnect.repository.JobPostRepository;
import com.zidio.zidioconnect.service.JobPostService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    private JobPost dtoToEntity(JobPostDTO dto) {
        return new JobPost(
                dto.getId(),
                dto.getJobTitle(),
                dto.getJobDescription(),
                dto.getJobLocation(),
                dto.getJobType(),
                dto.getCompanyName(),
                dto.getPostedByEmail(),
                dto.getPostedDate(),
                dto.getMinSalary(),
                dto.getMaxSalary(),
                dto.getMinExperience(),
                dto.getMaxExperience(),
                dto.getJobStatus(),
                dto.getLastDateToApply()
        );
    }

    private JobPostDTO entityToDto(JobPost entity) {
        return new JobPostDTO(
                entity.getId(),
                entity.getJobTitle(),
                entity.getJobDescription(),
                entity.getJobLocation(),
                entity.getJobType(),
                entity.getCompanyName(),
                entity.getPostedByEmail(),
                entity.getPostedDate(),
                entity.getMinSalary(),
                entity.getMaxSalary(),
                entity.getMinExperience(),
                entity.getMaxExperience(),
                entity.getJobStatus(),
                entity.getLastDateToApply()
        );
    }

    @Override
    public JobPostDTO createJobPost(JobPostDTO jobPostDTO) {
        JobPost jobPost = dtoToEntity(jobPostDTO);
        jobPost.setJobStatus(JobStatus.ACTIVE);
        return entityToDto(jobPostRepository.save(jobPost));
    }

    @Override
    public JobPostDTO getJobPostById(Long id) {
        JobPost jobPost = jobPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
        return entityToDto(jobPost);
    }

    @Override
    public List<JobPostDTO> getAllJobPosts() {
        return jobPostRepository.findAll().stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public JobPostDTO updateJobPost(Long id, JobPostDTO dto) {
        JobPost jobPost = jobPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));

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

        return entityToDto(jobPostRepository.save(jobPost));
    }

    @Override
    public void deleteJobPost(Long id) {
        jobPostRepository.deleteById(id);
    }
}
