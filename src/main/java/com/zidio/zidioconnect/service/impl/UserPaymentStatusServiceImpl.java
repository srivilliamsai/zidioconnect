package com.zidio.zidioconnect.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.dto.UserPaymentStatusDTO;
import com.zidio.zidioconnect.entity.UserPaymentStatus;
import com.zidio.zidioconnect.repository.UserPaymentStatusRepository;
import com.zidio.zidioconnect.service.UserPaymentStatusService;

@Service
public class UserPaymentStatusServiceImpl implements UserPaymentStatusService {

    @Autowired
    private UserPaymentStatusRepository repository;

    @Override
    public UserPaymentStatusDTO create(UserPaymentStatusDTO dto) {
        UserPaymentStatus status = new UserPaymentStatus(
            null,
            dto.getPlanId(),
            dto.getUserId(),
            dto.getSubscriptionStart(),
            dto.getSubscriptionEnd(),
            dto.getStatus()
        );
        status = repository.save(status);
        dto.setId(status.getId());
        return dto;
    }

    @Override
    public List<UserPaymentStatusDTO> getAll() {
        return repository.findAll().stream()
                .map(entity -> new UserPaymentStatusDTO(
                    entity.getId(),
                    entity.getPlanId(),
                    entity.getUserId(),
                    entity.getSubscriptionStart(),
                    entity.getSubscriptionEnd(),
                    entity.getStatus()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public UserPaymentStatusDTO getById(Long id) {
        UserPaymentStatus entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment status not found"));
        return new UserPaymentStatusDTO(
            entity.getId(),
            entity.getPlanId(),
            entity.getUserId(),
            entity.getSubscriptionStart(),
            entity.getSubscriptionEnd(),
            entity.getStatus()
        );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserPaymentStatusDTO update(Long id, UserPaymentStatusDTO dto) {
        UserPaymentStatus entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        entity.setPlanId(dto.getPlanId());
        entity.setUserId(dto.getUserId());
        entity.setSubscriptionStart(dto.getSubscriptionStart());
        entity.setSubscriptionEnd(dto.getSubscriptionEnd());
        entity.setStatus(dto.getStatus());
        repository.save(entity);
        return dto;
    }
}