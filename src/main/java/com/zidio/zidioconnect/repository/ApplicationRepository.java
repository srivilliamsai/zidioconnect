package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // Custom query methods (if needed in future)
    List<Application> findByStudentId(Long studentId);

    List<Application> findByJobId(Long jobId);

    List<Application> findByStatus(com.zidio.zidioconnect.enums.Status status);
}