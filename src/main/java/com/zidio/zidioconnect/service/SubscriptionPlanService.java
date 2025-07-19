package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.SubscriptionPlanDTO;
import java.util.List;

public interface SubscriptionPlanService {

    SubscriptionPlanDTO createPlan(SubscriptionPlanDTO dto);

    SubscriptionPlanDTO updatePlan(Long id, SubscriptionPlanDTO dto);

    SubscriptionPlanDTO getPlanById(Long id);

    List<SubscriptionPlanDTO> getAllPlans();

    void deletePlan(Long id);
}