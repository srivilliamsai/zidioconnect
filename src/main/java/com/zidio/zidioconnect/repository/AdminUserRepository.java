package com.zidio.zidioconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.zidioconnect.entity.AdminUser;

import java.util.Optional;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    Optional<AdminUser> findByEmail(String email);
    Optional<AdminUser> findByUsername(String username); // optional use
}
