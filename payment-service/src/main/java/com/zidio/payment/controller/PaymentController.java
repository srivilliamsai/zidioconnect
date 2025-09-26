package com.zidio.payment.controller;

import com.zidio.payment.entity.Payment;
import com.zidio.payment.enums.PaymentStatus;
import com.zidio.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("api/payments")
@Validated
public class PaymentController {
    private final PaymentService service;
    public PaymentController(PaymentService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Payment> create(@Valid @RequestBody Payment req){
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> get(@PathVariable Long id){
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Payment> list(@RequestParam(required = false) Long studentId){
        return studentId == null ? service.list() : service.byStudent(studentId);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Payment> updateStatus(@PathVariable Long id,
                                                @RequestParam PaymentStatus status,
                                                @RequestParam(required = false) String txId){
        return ResponseEntity.ok(service.updateStatus(id, status, txId));
    }
}
