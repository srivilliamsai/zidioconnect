package com.zidio.zidioconnect.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.zidioconnect.dto.UserPaymentStatusDTO;
import com.zidio.zidioconnect.service.UserPaymentStatusService;

@RestController
@RequestMapping("/api/user-subscription-status")
public class UserPaymentStatusController {

    @Autowired
    private UserPaymentStatusService userPaymentStatusService;

    @PostMapping
    public ResponseEntity<UserPaymentStatusDTO> assign(@RequestBody UserPaymentStatusDTO dto) {
        return ResponseEntity.ok(userPaymentStatusService.assignSubscriptionPlan(dto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserPaymentStatusDTO>> getStatus(@PathVariable Long userId) {
        return ResponseEntity.ok(userPaymentStatusService.getStatusByUserId(userId));
    }
}
