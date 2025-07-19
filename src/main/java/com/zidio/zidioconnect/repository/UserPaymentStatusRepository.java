package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.UserPaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserPaymentStatusRepository extends JpaRepository<UserPaymentStatus, Long> {
    List<UserPaymentStatus> findByUserId(Long userId); // ADDED
    List<UserPaymentStatus> findByStatus(String status); // ADDED
}