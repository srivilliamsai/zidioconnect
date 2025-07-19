package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.PaymentDTO;
import com.zidio.zidioconnect.entity.Payment;
import com.zidio.zidioconnect.enums.PaymentStatus;
import com.zidio.zidioconnect.repository.PaymentRepository;
import com.zidio.zidioconnect.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    private PaymentDTO mapToDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setUserId(payment.getUserId());
        dto.setPlanId(payment.getPlanId());
        dto.setAmount(payment.getAmount());
        dto.setCurrency(payment.getCurrency());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setPaymentType(payment.getPaymentType());
        dto.setTransactionId(payment.getTransactionId());
        return dto;
    }

    private Payment mapToEntity(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setId(dto.getId());
        payment.setUserId(dto.getUserId());
        payment.setPlanId(dto.getPlanId());
        payment.setAmount(dto.getAmount());
        payment.setCurrency(dto.getCurrency());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setPaymentStatus(dto.getPaymentStatus());
        payment.setPaymentType(dto.getPaymentType());
        payment.setTransactionId(dto.getTransactionId());
        return payment;
    }

    @Override
    public PaymentDTO createPayment(PaymentDTO dto) {
        Payment payment = mapToEntity(dto);
        return mapToDTO(paymentRepository.save(payment));
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Optional<Payment> optional = paymentRepository.findById(id);
        return optional.map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<PaymentDTO> getPaymentsByUserId(Long userId) {
        return paymentRepository.findByUserId(userId)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PaymentDTO updatePaymentStatus(Long id, String status) {
        Optional<Payment> optional = paymentRepository.findById(id);
        if (optional.isPresent()) {
            Payment payment = optional.get();
            payment.setPaymentStatus(PaymentStatus.valueOf(status.toUpperCase()));
            return mapToDTO(paymentRepository.save(payment));
        }
        return null;
    }
}