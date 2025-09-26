package com.zidio.subscription.service.impl;

import com.zidio.subscription.entity.SubscriptionPlan;
import com.zidio.subscription.repository.SubscriptionPlanRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SubscriptionPlanService {
    private final SubscriptionPlanRepository repo;
    public SubscriptionPlanService(SubscriptionPlanRepository repo){ this.repo = repo; }

    public SubscriptionPlan create(SubscriptionPlan p){ return repo.save(p); }
    public List<SubscriptionPlan> list(){ return repo.findAll(); }
    public Optional<SubscriptionPlan> get(Long id){ return repo.findById(id); }
}
