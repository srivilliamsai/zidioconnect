package com.zidio.zidioconnect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.dto.SubscriptionPlanDTO;
import com.zidio.zidioconnect.entity.SubscriptionPlan;
import com.zidio.zidioconnect.repository.SubscriptionPlanRepository;

@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public List<SubscriptionPlanDTO> getAllSubscriptionPlan() {
        return subscriptionPlanRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SubscriptionPlanDTO createSubscription(SubscriptionPlanDTO dto) {
        SubscriptionPlan subscription = convertToEntity(dto);
        SubscriptionPlan saved = subscriptionPlanRepository.save(subscription);
        return convertToDTO(saved);
    }

    private SubscriptionPlanDTO convertToDTO(SubscriptionPlan sub) {
        SubscriptionPlanDTO dto = new SubscriptionPlanDTO();
        dto.setId(sub.getId());
        dto.setName(sub.getName());
        dto.setPrice(sub.getPrice());
        dto.setDescription(sub.getDescription());
        dto.setDurationInDays(sub.getDurationInDays());
        return dto;
    }

    private SubscriptionPlan convertToEntity(SubscriptionPlanDTO dto) {
        SubscriptionPlan sub = new SubscriptionPlan();
        sub.setId(dto.getId());
        sub.setName(dto.getName());
        sub.setPrice(dto.getPrice());
        sub.setDescription(dto.getDescription());
        sub.setDurationInDays(dto.getDurationInDays());
        return sub;
    }
}
