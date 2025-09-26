package com.zidio.payment.service;

import com.zidio.payment.entity.Payment;
import com.zidio.payment.enums.PaymentStatus;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment create(Payment p);
    Optional<Payment> get(Long id);
    List<Payment> list();
    Payment updateStatus(Long id, PaymentStatus status, String txId);
    List<Payment> byStudent(Long studentId);
}
