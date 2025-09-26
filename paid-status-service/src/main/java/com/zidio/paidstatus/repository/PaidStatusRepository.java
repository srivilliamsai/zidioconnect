package com.zidio.paidstatus.repository;

import com.zidio.paidstatus.entity.PaidStatus;
import com.zidio.paidstatus.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaidStatusRepository extends JpaRepository<PaidStatus, Long> {
    List<PaidStatus> findByReferenceId(String referenceId);
    List<PaidStatus> findByUserId(Long userId);
    List<PaidStatus> findByStatus(PaymentStatus status);
}
