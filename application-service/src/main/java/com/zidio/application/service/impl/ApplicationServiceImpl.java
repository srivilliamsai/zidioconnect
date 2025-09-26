package com.zidio.application.service.impl;

import com.zidio.application.dto.ApplicationDTO;
import com.zidio.application.entity.Application;
import com.zidio.application.enums.ApplicationStatus;
import com.zidio.application.repository.ApplicationRepository;
import com.zidio.application.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository repository;

    public ApplicationServiceImpl(ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApplicationDTO create(ApplicationDTO dto) {
        Application entity = mapToEntity(dto);
        // Status kudutha illai na, default value APPLIED nu irukkum.
        if (entity.getStatus() == null) {
            entity.setStatus(ApplicationStatus.APPLIED);
        }
        return mapToDTO(repository.save(entity));
    }

    @Override
    public ApplicationDTO update(Long id, ApplicationDTO dto) {
        Application entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Application not found: " + id));

        entity.setCoverLetter(dto.getCoverLetter());
        entity.setResumeUrl(dto.getResumeUrl());
        entity.setStatus(dto.getStatus());
        entity.setFeedback(dto.getFeedback());
        entity.setShortlisted(dto.getShortlisted() != null ? dto.getShortlisted() : false);
        entity.setInterviewScheduled(dto.getInterviewScheduled() != null ? dto.getInterviewScheduled() : false);

        return mapToDTO(repository.save(entity));
    }

    @Override
    public ApplicationDTO get(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IllegalArgumentException("Application not found: " + id));
    }

    @Override
    public List<ApplicationDTO> list() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ApplicationDTO mapToDTO(Application entity) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setId(entity.getId());
        dto.setStudentId(entity.getStudentId());
        dto.setJobPostId(entity.getJobPostId());
        dto.setResumeUrl(entity.getResumeUrl());
        dto.setCoverLetter(entity.getCoverLetter());
        dto.setStatus(entity.getStatus());
        dto.setFeedback(entity.getFeedback());
        dto.setShortlisted(entity.getShortlisted());
        dto.setInterviewScheduled(entity.getInterviewScheduled());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    private Application mapToEntity(ApplicationDTO dto) {
        Application entity = new Application();
        entity.setStudentId(dto.getStudentId());
        entity.setJobPostId(dto.getJobPostId());
        entity.setResumeUrl(dto.getResumeUrl());
        entity.setCoverLetter(dto.getCoverLetter());
        entity.setStatus(dto.getStatus());
        entity.setFeedback(dto.getFeedback());
        // Null checks for boolean fields to prevent NullPointerException
        entity.setShortlisted(dto.getShortlisted() != null ? dto.getShortlisted() : false);
        entity.setInterviewScheduled(dto.getInterviewScheduled() != null ? dto.getInterviewScheduled() : false);
        return entity;
    }
}