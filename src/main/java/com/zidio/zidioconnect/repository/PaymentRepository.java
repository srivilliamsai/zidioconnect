package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(Long userId);
    List<Payment> findByPlanId(Long planId);
    List<Payment> findByPaymentStatus(String status);
}