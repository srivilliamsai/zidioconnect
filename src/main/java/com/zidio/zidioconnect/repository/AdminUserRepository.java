package com.zidio.zidioconnect.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.zidioconnect.entity.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    Optional<AdminUser> findByEmail(String email);
}