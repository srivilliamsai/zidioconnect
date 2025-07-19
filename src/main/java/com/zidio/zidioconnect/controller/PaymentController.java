package com.zidio.zidioconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zidio.zidioconnect.dto.PaymentDTO;
import com.zidio.zidioconnect.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentDTO makePayment(@RequestBody PaymentDTO dto) {
        return paymentService.makePayment(dto);
    }

    @GetMapping
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/user/{userId}")
    public List<PaymentDTO> getPaymentsByUser(@PathVariable Long userId) {
        return paymentService.getPaymentsByUserId(userId);
    }
}
