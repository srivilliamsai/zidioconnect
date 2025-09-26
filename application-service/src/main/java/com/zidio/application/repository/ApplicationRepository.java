package com.zidio.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.application.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
