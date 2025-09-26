package com.zidio.admin.service;

import com.zidio.admin.dto.AdminDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {
    AdminDTO create(AdminDTO dto);
    AdminDTO get(Long id);
    Page<AdminDTO> list(Pageable pageable);
    AdminDTO update(Long id, AdminDTO dto);
    void delete(Long id);
}