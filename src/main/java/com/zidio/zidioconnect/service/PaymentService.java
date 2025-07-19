package com.zidio.zidioconnect.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.dto.PaymentDTO;
import com.zidio.zidioconnect.entity.Payment;
import com.zidio.zidioconnect.enums.PaymentStatus;
import com.zidio.zidioconnect.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentDTO makePayment(PaymentDTO dto) {
        Payment pay = new Payment();

        pay.setUserId(dto.getUserId());
        pay.setPlanId(dto.getPlanId());
        pay.setAmount(dto.getAmount());
        pay.setCurrency(dto.getCurrency());
        pay.setPaymentType(dto.getPaymentType());
        pay.setPaymentStatus(PaymentStatus.SUCCESS); // or dynamically set based on logic
        pay.setPaymentDate(LocalDateTime.now());
        pay.setTransactionId("TXN" + UUID.randomUUID().toString().replace("-", "").substring(0, 12));

        Payment saved = paymentRepository.save(pay);

        dto.setId(saved.getId());
        dto.setPaymentDate(saved.getPaymentDate());
        dto.setTransactionId(saved.getTransactionId());
        dto.setPaymentStatus(saved.getPaymentStatus());

        return dto;
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<PaymentDTO> getPaymentsByUserId(Long userId) {
        return paymentRepository.findByUserId(userId).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private PaymentDTO convertToDto(Payment p) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(p.getId());
        dto.setUserId(p.getUserId());
        dto.setPlanId(p.getPlanId());
        dto.setAmount(p.getAmount());
        dto.setCurrency(p.getCurrency());
        dto.setPaymentType(p.getPaymentType());
        dto.setPaymentStatus(p.getPaymentStatus());
        dto.setPaymentDate(p.getPaymentDate());
        dto.setTransactionId(p.getTransactionId());
        return dto;
    }
}


