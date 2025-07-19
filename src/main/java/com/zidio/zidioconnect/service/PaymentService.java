package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO createPayment(PaymentDTO paymentDTO);
    PaymentDTO getPaymentById(Long id);
    List<PaymentDTO> getPaymentsByUserId(Long userId);
    List<PaymentDTO> getAllPayments();
    PaymentDTO updatePaymentStatus(Long id, String status);
}
