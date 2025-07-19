package com.zidio.zidioconnect.entity;

import java.util.Date;

import javax.persistence.*;

import com.zidio.zidioconnect.enums.Status;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long jobId;
    private String resumeURL;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date appliedDate;

    // NEW FIELDS
    private String feedback;                 // Admin/recruiter feedback
    private boolean shortlisted = false;     // For shortlist marking
    private boolean interviewScheduled = false; // Status of interview

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Application() {
    }
    
    public Application(Long id, Long studentId, Long jobId, String resumeURL, Status status, Date appliedDate,
                       String feedback, boolean shortlisted, boolean interviewScheduled, Date updatedAt) {
        this.id = id;
        this.studentId = studentId;
        this.jobId = jobId;
        this.resumeURL = resumeURL;
        this.status = status;
        this.appliedDate = appliedDate;
        this.feedback = feedback;
        this.shortlisted = shortlisted;
        this.interviewScheduled = interviewScheduled;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getResumeURL() {
        return resumeURL;
    }

    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isShortlisted() {
        return shortlisted;
    }

    public void setShortlisted(boolean shortlisted) {
        this.shortlisted = shortlisted;
    }

    public boolean isInterviewScheduled() {
        return interviewScheduled;
    }

    public void setInterviewScheduled(boolean interviewScheduled) {
        this.interviewScheduled = interviewScheduled;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}