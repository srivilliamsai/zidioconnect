package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {

    ApplicationDTO createApplication(ApplicationDTO applicationDTO);

    ApplicationDTO getApplicationById(Long id);

    List<ApplicationDTO> getApplicationsByStudentId(Long studentId);

    List<ApplicationDTO> getApplicationsByJobId(Long jobId);

    ApplicationDTO updateApplication(Long id, ApplicationDTO applicationDTO);

    void deleteApplication(Long id);
}
