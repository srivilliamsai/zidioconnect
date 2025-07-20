package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.AuthResponse;
import com.zidio.zidioconnect.dto.RegisterRequest;
import com.zidio.zidioconnect.dto.SystemUserDTO;

public interface AuthService {
    AuthResponse login(String email, String password);
    AuthResponse register(SystemUserDTO userDTO);
    AuthResponse register(RegisterRequest request);
}
