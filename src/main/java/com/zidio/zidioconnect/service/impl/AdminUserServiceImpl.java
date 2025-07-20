package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.AdminUserDTO;
import com.zidio.zidioconnect.entity.AdminUser;
import com.zidio.zidioconnect.repository.AdminUserRepository;
import com.zidio.zidioconnect.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminRepo;

    private AdminUserDTO convertToDTO(AdminUser user) {
        return new AdminUserDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getUsername(),
            user.getRole(),
            user.isActive(),
            user.isBlocked()
        );
    }

    private AdminUser convertToEntity(AdminUserDTO dto) {
        AdminUser user = new AdminUser();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());
        user.setActive(dto.isActive());
        user.setBlocked(dto.isBlocked());
        return user;
    }

    @Override
    public AdminUserDTO createAdmin(AdminUserDTO adminDTO) {
        AdminUser saved = adminRepo.save(convertToEntity(adminDTO));
        return convertToDTO(saved);
    }

    @Override
    public List<AdminUserDTO> getAllAdmins() {
        return adminRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdminUserDTO getAdminById(Long id) {
        AdminUser user = adminRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id " + id));
        return convertToDTO(user);
    }

    @Override
    public AdminUserDTO updateAdmin(Long id, AdminUserDTO dto) {
        AdminUser existing = adminRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id " + id));
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setUsername(dto.getUsername());
        existing.setRole(dto.getRole());
        existing.setActive(dto.isActive());
        existing.setBlocked(dto.isBlocked());
        return convertToDTO(adminRepo.save(existing));
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepo.deleteById(id);
    }
}
