package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.SubscriptionPlanDTO;
import com.zidio.zidioconnect.entity.SubscriptionPlan;
import com.zidio.zidioconnect.repository.SubscriptionPlanRepository;
import com.zidio.zidioconnect.service.SubscriptionPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository planRepository;

    private SubscriptionPlanDTO mapToDTO(SubscriptionPlan plan) {
        return new SubscriptionPlanDTO(
                plan.getId(),
                plan.getName(),
                plan.getDescription(),
                plan.getPrice(),
                plan.getDurationInDays(),
                plan.getPlanType(),
                plan.getIsActive()
        );
    }

    private SubscriptionPlan mapToEntity(SubscriptionPlanDTO dto) {
        SubscriptionPlan plan = new SubscriptionPlan();
        plan.setId(dto.getId());
        plan.setName(dto.getName());
        plan.setDescription(dto.getDescription());
        plan.setPrice(dto.getPrice());
        plan.setDurationInDays(dto.getDurationInDays());
        plan.setPlanType(dto.getPlanType());
        plan.setIsActive(dto.getIsActive());
        return plan;
    }

    @Override
    public SubscriptionPlanDTO createPlan(SubscriptionPlanDTO dto) {
        SubscriptionPlan saved = planRepository.save(mapToEntity(dto));
        return mapToDTO(saved);
    }

    @Override
    public SubscriptionPlanDTO updatePlan(Long id, SubscriptionPlanDTO dto) {
        Optional<SubscriptionPlan> optional = planRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Subscription Plan not found");
        }
        SubscriptionPlan plan = optional.get();
        plan.setName(dto.getName());
        plan.setDescription(dto.getDescription());
        plan.setPrice(dto.getPrice());
        plan.setDurationInDays(dto.getDurationInDays());
        plan.setPlanType(dto.getPlanType());
        plan.setIsActive(dto.getIsActive());
        return mapToDTO(planRepository.save(plan));
    }

    @Override
    public SubscriptionPlanDTO getPlanById(Long id) {
        return planRepository.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
    }

    @Override
    public List<SubscriptionPlanDTO> getAllPlans() {
        return planRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}