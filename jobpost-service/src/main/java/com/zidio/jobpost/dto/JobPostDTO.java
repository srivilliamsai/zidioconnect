package com.zidio.jobpost.dto;

import com.zidio.jobpost.enums.JobStatus;
import com.zidio.jobpost.enums.JobType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class JobPostDTO {

    private Long id;

    @NotBlank @Size(max = 150)
    private String title;

    @NotBlank
    private String description;

    @NotBlank @Size(max = 120)
    private String company;

    @Size(max = 120)
    private String location;

    private BigDecimal salaryMin;
    private BigDecimal salaryMax;

    private JobType jobType;
    private JobStatus status;

    /** Comma-separated skills */
    @Size(max = 500)
    private String skills;

    private LocalDate lastDateToApply;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public BigDecimal getSalaryMin() { return salaryMin; }
    public void setSalaryMin(BigDecimal salaryMin) { this.salaryMin = salaryMin; }

    public BigDecimal getSalaryMax() { return salaryMax; }
    public void setSalaryMax(BigDecimal salaryMax) { this.salaryMax = salaryMax; }

    public JobType getJobType() { return jobType; }
    public void setJobType(JobType jobType) { this.jobType = jobType; }

    public JobStatus getStatus() { return status; }
    public void setStatus(JobStatus status) { this.status = status; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public LocalDate getLastDateToApply() { return lastDateToApply; }
    public void setLastDateToApply(LocalDate lastDateToApply) { this.lastDateToApply = lastDateToApply; }
}
