package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.SystemUserDTO;
import com.zidio.zidioconnect.entity.SystemUser;
import com.zidio.zidioconnect.enums.Role;

import java.util.List;
import java.util.Optional;

public interface SystemUserService {
    SystemUserDTO createSystemUser(SystemUserDTO dto, String rawPassword);
    List<SystemUserDTO> getAllSystemUsers();
    Optional<SystemUser> getByEmail(String email);
    void deactivateUser(Long id);
    SystemUserDTO createUser(SystemUserDTO dto);
    List<SystemUserDTO> getAllUsers();
    SystemUserDTO getUserById(Long id);
    SystemUserDTO updateUser(Long id, SystemUserDTO dto);
    void deleteUser(Long id);
    List<SystemUserDTO> getUsersByRole(Role role);
}
