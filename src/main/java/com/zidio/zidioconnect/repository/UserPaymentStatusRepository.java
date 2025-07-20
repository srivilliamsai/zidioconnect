package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.UserPaymentStatus;
import com.zidio.zidioconnect.enums.PaidStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserPaymentStatusRepository extends JpaRepository<UserPaymentStatus, Long> {
    List<UserPaymentStatus> findByUserId(Long userId);
    List<UserPaymentStatus> findByStatus(String status);
    
    long countByStatus(PaidStatus status);  // Correct method
}
