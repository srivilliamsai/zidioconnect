package com.zidio.zidioconnect.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.zidioconnect.entity.UserPaymentStatus;

@Repository
public interface UserPaymentStatusRepository extends JpaRepository<UserPaymentStatus, Long> {
    Optional<UserPaymentStatus> findByUserId(Long userId);
}
