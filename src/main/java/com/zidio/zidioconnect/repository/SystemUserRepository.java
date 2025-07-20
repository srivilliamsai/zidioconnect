package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.SystemUser;
import com.zidio.zidioconnect.enums.PaidStatus;
import com.zidio.zidioconnect.enums.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

    Optional<SystemUser> findByEmail(String email);

    List<SystemUser> findByRole(Role role); //  Fixed generic type

    boolean existsByEmail(String email);

    long countByPaidStatus(PaidStatus status); //  For analytics
}
