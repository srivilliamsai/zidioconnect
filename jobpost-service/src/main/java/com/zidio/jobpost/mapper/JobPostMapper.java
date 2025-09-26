package com.zidio.jobpost.mapper;

import com.zidio.jobpost.dto.JobPostDTO;
import com.zidio.jobpost.entity.JobPost;
import org.springframework.stereotype.Component;

@Component
public class JobPostMapper {

    public JobPostDTO toDTO(JobPost e) {
        if (e == null) return null;
        JobPostDTO d = new JobPostDTO();
        d.setId(e.getId());
        d.setTitle(e.getTitle());
        d.setDescription(e.getDescription());
        d.setCompany(e.getCompany());
        d.setLocation(e.getLocation());
        d.setSalaryMin(e.getSalaryMin());
        d.setSalaryMax(e.getSalaryMax());
        d.setJobType(e.getJobType());
        d.setStatus(e.getStatus());
        d.setSkills(e.getSkills());
        d.setLastDateToApply(e.getLastDateToApply());
        return d;
    }

    public JobPost toEntity(JobPostDTO d) {
        if (d == null) return null;
        JobPost e = new JobPost();
        e.setId(d.getId());
        e.setTitle(d.getTitle());
        e.setDescription(d.getDescription());
        e.setCompany(d.getCompany());
        e.setLocation(d.getLocation());
        e.setSalaryMin(d.getSalaryMin());
        e.setSalaryMax(d.getSalaryMax());
        e.setJobType(d.getJobType());
        e.setStatus(d.getStatus());
        e.setSkills(d.getSkills());
        e.setLastDateToApply(d.getLastDateToApply());
        return e;
    }

    public void copyToEntity(JobPostDTO d, JobPost e) {
        if (d == null || e == null) return;
        e.setTitle(d.getTitle());
        e.setDescription(d.getDescription());
        e.setCompany(d.getCompany());
        e.setLocation(d.getLocation());
        e.setSalaryMin(d.getSalaryMin());
        e.setSalaryMax(d.getSalaryMax());
        e.setJobType(d.getJobType());
        e.setStatus(d.getStatus());
        e.setSkills(d.getSkills());
        e.setLastDateToApply(d.getLastDateToApply());
    }
}