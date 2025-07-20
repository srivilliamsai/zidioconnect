package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.ApplicationDTO;
import com.zidio.zidioconnect.entity.Application;
import com.zidio.zidioconnect.entity.JobPost;
import com.zidio.zidioconnect.enums.Status;
import com.zidio.zidioconnect.repository.ApplicationRepository;
import com.zidio.zidioconnect.repository.JobPostRepository;
import com.zidio.zidioconnect.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobPostRepository jobPostRepository;  // Added for JobPost fetching

    // Helper methods to convert Entity <-> DTO

    private ApplicationDTO toDTO(Application application) {
        if (application == null) return null;
        return new ApplicationDTO(
                application.getId(),
                application.getStudentId(),
                application.getJobPost() != null ? application.getJobPost().getId() : null,
                application.getResumeURL(),
                application.getStatus(),
                application.getAppliedDate(),
                application.getFeedback(),
                application.isShortlisted(),
                application.isInterviewScheduled(),
                application.getUpdatedAt()
        );
    }

    private Application toEntity(ApplicationDTO dto) {
        Application application = new Application();
        application.setId(dto.getId());
        application.setStudentId(dto.getStudentId());

        if (dto.getJobId() != null) {
            JobPost jobPost = jobPostRepository.findById(dto.getJobId())
                    .orElseThrow(() -> new EntityNotFoundException("JobPost not found with id " + dto.getJobId()));
            application.setJobPost(jobPost);
        } else {
            application.setJobPost(null);
        }

        application.setResumeURL(dto.getResumeURL());
        application.setStatus(dto.getStatus() != null ? dto.getStatus() : Status.APPLIED); // default status
        application.setAppliedDate(dto.getAppliedDate() != null ? dto.getAppliedDate() : new Date());
        application.setFeedback(dto.getFeedback());
        application.setShortlisted(dto.isShortlisted());
        application.setInterviewScheduled(dto.isInterviewScheduled());
        application.setUpdatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : new Date());
        return application;
    }

    @Override
    public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {
        Application application = toEntity(applicationDTO);
        application.setAppliedDate(new Date());
        application.setUpdatedAt(new Date());
        Application saved = applicationRepository.save(application);
        return toDTO(saved);
    }

    @Override
    public ApplicationDTO getApplicationById(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Application not found with id " + id));
        return toDTO(application);
    }

    @Override
    public List<ApplicationDTO> getApplicationsByStudentId(Long studentId) {
        List<Application> applications = applicationRepository.findByStudentId(studentId);
        return applications.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDTO> getApplicationsByJobId(Long jobId) {
        List<Application> applications = applicationRepository.findByJobPostId(jobId);
        return applications.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ApplicationDTO updateApplication(Long id, ApplicationDTO applicationDTO) {
        Application existing = applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Application not found with id " + id));

        // Update fields from DTO
        existing.setStudentId(applicationDTO.getStudentId());
        if (applicationDTO.getJobId() != null) {
            JobPost jobPost = jobPostRepository.findById(applicationDTO.getJobId())
                    .orElseThrow(() -> new EntityNotFoundException("JobPost not found with id " + applicationDTO.getJobId()));
            existing.setJobPost(jobPost);
        }
        existing.setResumeURL(applicationDTO.getResumeURL());
        existing.setStatus(applicationDTO.getStatus());
        existing.setFeedback(applicationDTO.getFeedback());
        existing.setShortlisted(applicationDTO.isShortlisted());
        existing.setInterviewScheduled(applicationDTO.isInterviewScheduled());
        existing.setUpdatedAt(new Date());

        Application saved = applicationRepository.save(existing);
        return toDTO(saved);
    }

    @Override
    public void deleteApplication(Long id) {
        Application existing = applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Application not found with id " + id));
        applicationRepository.delete(existing);
    }
}
