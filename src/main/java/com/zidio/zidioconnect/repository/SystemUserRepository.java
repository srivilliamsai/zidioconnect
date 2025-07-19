package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
    Optional<SystemUser> findByEmail(String email);
    boolean existsByEmail(String email);
}