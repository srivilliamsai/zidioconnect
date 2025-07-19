package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.SystemUserDTO;
import com.zidio.zidioconnect.entity.SystemUser;
import com.zidio.zidioconnect.enums.Role;
import com.zidio.zidioconnect.repository.SystemUserRepository;
import com.zidio.zidioconnect.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public SystemUserDTO createSystemUser(SystemUserDTO dto, String password) {
        SystemUser user = new SystemUser();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(dto.getRole() != null ? dto.getRole() : Role.STUDENT);
        user.setActive(true);
        repository.save(user);
        dto.setId(user.getId());
        return dto;
    }

    @Override
    public List<SystemUserDTO> getAllSystemUsers() {
        return repository.findAll().stream()
                .map(u -> new SystemUserDTO(
                        u.getId(), u.getName(), u.getEmail(), u.getRole(), u.isActive()
                )).collect(Collectors.toList());
    }

    @Override
    public Optional<SystemUser> getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void deactivateUser(Long id) {
        repository.findById(id).ifPresent(user -> {
            user.setActive(false);
            repository.save(user);
        });
    }
}