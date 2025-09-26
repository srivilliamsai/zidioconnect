package com.zidio.subscription.service.impl;

import com.zidio.subscription.entity.Subscription;
import com.zidio.subscription.enums.SubscriptionStatus;
import com.zidio.subscription.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class SubscriptionServiceImpl {
    private final SubscriptionRepository repo;
    public SubscriptionServiceImpl(SubscriptionRepository repo){ this.repo = repo; }

    public Subscription create(Subscription s){ return repo.save(s); }
    public Optional<Subscription> get(Long id){ return repo.findById(id); }
    public List<Subscription> list(){ return repo.findAll(); }
    public List<Subscription> byStudent(Long studentId){ return repo.findByStudentId(studentId); }

    public Subscription cancel(Long id){
        Subscription s = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
        s.setStatus(SubscriptionStatus.CANCELLED);
        return repo.save(s);
    }

    public Subscription extend(Long id, int extraDays){
        Subscription s = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
        s.setEndDate(s.getEndDate().plusDays(extraDays));
        if (s.getEndDate().isAfter(LocalDate.now())) s.setStatus(SubscriptionStatus.ACTIVE);
        return repo.save(s);
    }
}
