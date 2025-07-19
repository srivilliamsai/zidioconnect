package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.ApplicationDTO;
import java.util.List;

public interface ApplicationService {
    ApplicationDTO createApplication(ApplicationDTO dto);
    ApplicationDTO getApplicationById(Long id);
    List<ApplicationDTO> getAllApplications();
    void deleteApplication(Long id);
    ApplicationDTO updateApplication(Long id, ApplicationDTO dto);
}