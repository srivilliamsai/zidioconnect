package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudentId(Long studentId);

    List<Application> findByJobPostId(Long jobId);

    @Query("SELECT j.jobTitle, COUNT(a) FROM Application a JOIN a.jobPost j GROUP BY j.jobTitle")
    List<Object[]> countApplicationsGroupedByJobTitle();
}
