package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.SystemUserDTO;
import com.zidio.zidioconnect.entity.SystemUser;

import java.util.List;
import java.util.Optional;

public interface SystemUserService {
    SystemUserDTO createSystemUser(SystemUserDTO systemUserDTO, String password);
    List<SystemUserDTO> getAllSystemUsers();
    Optional<SystemUser> getByEmail(String email);
    void deactivateUser(Long id);
}