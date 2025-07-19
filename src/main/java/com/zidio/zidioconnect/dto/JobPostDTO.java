package com.zidio.zidioconnect.dto;

import java.util.Date;

import com.zidio.zidioconnect.enums.JobStatus;
import com.zidio.zidioconnect.enums.JobType;

public class JobPostDTO {

    private Long id;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private JobType jobType;
    private String companyName;
    private String postedByEmail;
    private Date postedDate;
    private Double minSalary;
    private Double maxSalary;
    private Integer minExperience;
    private Integer maxExperience;
    private JobStatus jobStatus;
    private Date lastDateToApply;

    public JobPostDTO() {}

    public JobPostDTO(Long id, String jobTitle, String jobDescription, String jobLocation,
                      JobType jobType, String companyName, String postedByEmail, Date postedDate,
                      Double minSalary, Double maxSalary, Integer minExperience, Integer maxExperience,
                      JobStatus jobStatus, Date lastDateToApply) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.jobType = jobType;
        this.companyName = companyName;
        this.postedByEmail = postedByEmail;
        this.postedDate = postedDate;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.minExperience = minExperience;
        this.maxExperience = maxExperience;
        this.jobStatus = jobStatus;
        this.lastDateToApply = lastDateToApply;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPostedByEmail() {
        return postedByEmail;
    }

    public void setPostedByEmail(String postedByEmail) {
        this.postedByEmail = postedByEmail;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Integer getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(Integer minExperience) {
        this.minExperience = minExperience;
    }

    public Integer getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(Integer maxExperience) {
        this.maxExperience = maxExperience;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getLastDateToApply() {
        return lastDateToApply;
    }

    public void setLastDateToApply(Date lastDateToApply) {
        this.lastDateToApply = lastDateToApply;
    }
}