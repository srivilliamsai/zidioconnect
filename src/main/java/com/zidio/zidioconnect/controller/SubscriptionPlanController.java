package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.SubscriptionPlanDTO;
import com.zidio.zidioconnect.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription-plans")
@CrossOrigin("*")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @PostMapping
    public ResponseEntity<SubscriptionPlanDTO> createPlan(@RequestBody SubscriptionPlanDTO dto) {
        return ResponseEntity.ok(subscriptionPlanService.createPlan(dto));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionPlanDTO>> getAllPlans() {
        return ResponseEntity.ok(subscriptionPlanService.getAllPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlanDTO> getPlanById(@PathVariable Long id) {
        SubscriptionPlanDTO plan = subscriptionPlanService.getPlanById(id);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        subscriptionPlanService.deletePlan(id);
        return ResponseEntity.ok("Subscription plan deleted successfully");
    }
}