package com.zidio.zidioconnect.entity;

import com.zidio.zidioconnect.enums.JobStatus;
import com.zidio.zidioconnect.enums.JobType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job_posts")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;
    private String jobDescription;
    private String jobLocation;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private String companyName;
    private String postedByEmail;

    @Temporal(TemporalType.DATE)
    private Date postedDate;

    private Double minSalary;
    private Double maxSalary;

    private Double minExperience;
    private Double maxExperience;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    @Temporal(TemporalType.DATE)
    private Date lastDateToApply;

    public JobPost() {
    }

    public JobPost(Long id, String jobTitle, String jobDescription, String jobLocation, JobType jobType,
                   String companyName, String postedByEmail, Date postedDate, Double minSalary, Double maxSalary,
                   Double minExperience, Double maxExperience, JobStatus jobStatus, Date lastDateToApply) {
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

    // Getters and Setters for all fields

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

    public Double getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(Double minExperience) {
        this.minExperience = minExperience;
    }

    public Double getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(Double maxExperience) {
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
