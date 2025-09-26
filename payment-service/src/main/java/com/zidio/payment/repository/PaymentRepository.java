package com.zidio.payment.repository;

import com.zidio.payment.entity.Payment;
import com.zidio.payment.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentId(Long studentId);
    List<Payment> findByStatus(PaymentStatus status);
}
