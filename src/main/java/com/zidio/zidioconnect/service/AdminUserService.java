package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.AdminUserDTO;
import java.util.List;

public interface AdminUserService {
    AdminUserDTO createAdmin(AdminUserDTO adminDTO);
    List<AdminUserDTO> getAllAdmins();
    AdminUserDTO getAdminById(Long id);
    AdminUserDTO updateAdmin(Long id, AdminUserDTO adminDTO);
    void deleteAdmin(Long id);
}