package com.zidio.subscription.repository;

import com.zidio.subscription.entity.Subscription;
import com.zidio.subscription.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByStudentId(Long studentId);
    List<Subscription> findByStatus(SubscriptionStatus status);
}
