package com.zidio.paidstatus.service;

import com.zidio.paidstatus.entity.PaidStatus;
import com.zidio.paidstatus.enums.PaymentStatus;

import java.util.List;
import java.util.Optional;

public interface PaidStatusService {
    PaidStatus create(PaidStatus input);
    Optional<PaidStatus> get(Long id);
    List<PaidStatus> list();
    List<PaidStatus> byReference(String referenceId);
    List<PaidStatus> byUser(Long userId);
    PaidStatus updateStatus(Long id, PaymentStatus status);
    void delete(Long id);
}
