package com.zidio.subscription.controller;

import com.zidio.subscription.entity.SubscriptionPlan;
import com.zidio.subscription.service.impl.SubscriptionPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController @RequestMapping("/plans")
public class PlanController {
    private final SubscriptionPlanService service;
    public PlanController(SubscriptionPlanService service){ this.service = service; }

    @PostMapping public SubscriptionPlan create(@Valid @RequestBody SubscriptionPlan plan){ return service.create(plan); }
    @GetMapping public List<SubscriptionPlan> list(){ return service.list(); }
    @GetMapping("/{id}") public ResponseEntity<SubscriptionPlan> get(@PathVariable Long id){
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
