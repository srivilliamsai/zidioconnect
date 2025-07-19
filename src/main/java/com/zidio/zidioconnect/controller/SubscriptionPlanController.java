package com.zidio.zidioconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.zidioconnect.dto.SubscriptionPlanDTO;
import com.zidio.zidioconnect.service.SubscriptionPlanService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @GetMapping
    public ResponseEntity<List<SubscriptionPlanDTO>> getAll() {
        return ResponseEntity.ok(subscriptionPlanService.getAllSubscriptionPlan());
    }

    @PostMapping
    public ResponseEntity<SubscriptionPlanDTO> create(@RequestBody SubscriptionPlanDTO dto) {
        return ResponseEntity.ok(subscriptionPlanService.createSubscription(dto));
    }
}
