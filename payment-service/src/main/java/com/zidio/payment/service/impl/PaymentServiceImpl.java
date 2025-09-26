package com.zidio.payment.service.impl;

import com.zidio.payment.entity.Payment;
import com.zidio.payment.enums.PaymentStatus;
import com.zidio.payment.repository.PaymentRepository;
import com.zidio.payment.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repo;
    public PaymentServiceImpl(PaymentRepository repo){ this.repo = repo; }

    @Override public Payment create(Payment p){ return repo.save(p); }
    @Override public Optional<Payment> get(Long id){ return repo.findById(id); }
    @Override public List<Payment> list(){ return repo.findAll(); }

    @Override
    public Payment updateStatus(Long id, PaymentStatus status, String txId){
        Payment p = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Payment not found"));
        p.setStatus(status);
        if (txId != null && !txId.isEmpty()) p.setTransactionId(txId);
        return repo.save(p);
    }

    @Override public List<Payment> byStudent(Long studentId){ return repo.findByStudentId(studentId); }
}
