package com.zidio.application.service;

import com.zidio.application.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {
    ApplicationDTO create(ApplicationDTO dto);
    ApplicationDTO update(Long id, ApplicationDTO dto);
    ApplicationDTO get(Long id);
    List<ApplicationDTO> list();
    void delete(Long id);
}