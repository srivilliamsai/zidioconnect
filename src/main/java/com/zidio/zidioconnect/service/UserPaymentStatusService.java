package com.zidio.zidioconnect.service;

import java.util.List;

import com.zidio.zidioconnect.dto.UserPaymentStatusDTO;

public interface UserPaymentStatusService {
    UserPaymentStatusDTO create(UserPaymentStatusDTO dto); // ADDED
    List<UserPaymentStatusDTO> getAll(); // ADDED
    UserPaymentStatusDTO getById(Long id); // ADDED
    void delete(Long id); // ADDED
    UserPaymentStatusDTO update(Long id, UserPaymentStatusDTO dto); // ADDED
}