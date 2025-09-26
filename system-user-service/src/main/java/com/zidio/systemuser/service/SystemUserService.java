package com.zidio.systemuser.service;

import com.zidio.systemuser.dto.CreateUserDTO;
import com.zidio.systemuser.dto.UpdateUserDTO;
import com.zidio.systemuser.dto.UserDTO;

import java.util.List;

public interface SystemUserService {
    UserDTO create(CreateUserDTO dto);
    UserDTO get(Long id);
    List<UserDTO> list();
    UserDTO update(Long id, UpdateUserDTO dto);
    void delete(Long id);
}
