package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.PaymentDTO;
import com.zidio.zidioconnect.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*") // Optional: Enable CORS for frontend access
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create a new payment
    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO dto) {
        PaymentDTO created = paymentService.createPayment(dto); // Create payment
        return ResponseEntity.ok(created); // Return response
    }

    // Get a payment by its ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getById(@PathVariable Long id) {
        PaymentDTO dto = paymentService.getPaymentById(id); // Fetch payment by ID
        return ResponseEntity.ok(dto);
    }

    // Get all payments for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentDTO>> getByUserId(@PathVariable Long userId) {
        List<PaymentDTO> userPayments = paymentService.getPaymentsByUserId(userId); // List for user
        return ResponseEntity.ok(userPayments);
    }

    // Get all payments (admin or overview purpose)
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAll() {
        List<PaymentDTO> allPayments = paymentService.getAllPayments(); // All payments
        return ResponseEntity.ok(allPayments);
    }

    // Update the status of a payment (e.g., from PENDING to SUCCESS)
    @PutMapping("/{id}/status")
    public ResponseEntity<PaymentDTO> updateStatus(@PathVariable Long id, @RequestParam String status) {
        PaymentDTO updated = paymentService.updatePaymentStatus(id, status); // Update status
        return ResponseEntity.ok(updated);
    }
}
