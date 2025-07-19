package com.zidio.zidioconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.zidioconnect.entity.SystemUser;
import com.zidio.zidioconnect.enums.Role;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

    SystemUser findByEmail(String email);

    List<SystemUser> findByRole(Role role);  
    
}
