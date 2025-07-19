package com.zidio.zidioconnect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.dto.SystemUserDTO;
import com.zidio.zidioconnect.entity.SystemUser;
import com.zidio.zidioconnect.enums.Role;
import com.zidio.zidioconnect.repository.SystemUserRepository;

@Service
public class AdminService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    public List<SystemUserDTO> getAllUsers() {
        return systemUserRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void blockUser(Long id) {
        SystemUser user = systemUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(false);  // use boolean isActive
        systemUserRepository.save(user);
    }

    public void unBlockUser(Long id) {
        SystemUser user = systemUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(true);  // use boolean isActive
        systemUserRepository.save(user);
    }

    public List<SystemUserDTO> getUserByRole(Role role) {
        return systemUserRepository.findByRole(role)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public SystemUserDTO updateStatus(String email, boolean isActive) {
        SystemUser user = systemUserRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.setActive(isActive);
        systemUserRepository.save(user);
        return toDTO(user);
    }

    private SystemUserDTO toDTO(SystemUser user) {
        return new SystemUserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.isActive()
        );
    }
}
