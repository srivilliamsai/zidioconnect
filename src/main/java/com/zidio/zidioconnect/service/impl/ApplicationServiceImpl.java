package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.ApplicationDTO;
import com.zidio.zidioconnect.entity.Application;
import com.zidio.zidioconnect.enums.Status;
import com.zidio.zidioconnect.repository.ApplicationRepository;
import com.zidio.zidioconnect.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository repository;

    private ApplicationDTO convertToDTO(Application app) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setId(app.getId());
        dto.setStudentId(app.getStudentId());
        dto.setJobId(app.getJobId());
        dto.setResumeURL(app.getResumeURL());
        dto.setStatus(app.getStatus());
        dto.setAppliedDate(app.getAppliedDate());
        return dto;
    }

    private Application convertToEntity(ApplicationDTO dto) {
        Application app = new Application();
        app.setId(dto.getId());
        app.setStudentId(dto.getStudentId());
        app.setJobId(dto.getJobId());
        app.setResumeURL(dto.getResumeURL());
        app.setStatus(dto.getStatus() != null ? dto.getStatus() : Status.PENDING);
        app.setAppliedDate(dto.getAppliedDate());
        return app;
    }

    @Override
    public ApplicationDTO createApplication(ApplicationDTO dto) {
        Application saved = repository.save(convertToEntity(dto));
        return convertToDTO(saved);
    }

    @Override
    public ApplicationDTO getApplicationById(Long id) {
        Optional<Application> app = repository.findById(id);
        return app.map(this::convertToDTO).orElse(null);
    }

    @Override
    public List<ApplicationDTO> getAllApplications() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ApplicationDTO updateApplication(Long id, ApplicationDTO dto) {
        Optional<Application> existing = repository.findById(id);
        if (existing.isPresent()) {
            Application updated = convertToEntity(dto);
            updated.setId(id);
            return convertToDTO(repository.save(updated));
        }
        return null;
    }
}