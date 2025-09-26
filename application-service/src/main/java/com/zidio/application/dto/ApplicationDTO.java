package com.zidio.application.dto;

import com.zidio.application.enums.ApplicationStatus;
import java.time.LocalDateTime;

public class ApplicationDTO {

    private Long id;
    private Long studentId;
    private Long jobPostId;
    private String resumeUrl;
    private String coverLetter;
    private ApplicationStatus status;
    private String feedback;
    private Boolean shortlisted;
    private Boolean interviewScheduled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getJobPostId() { return jobPostId; }
    public void setJobPostId(Long jobPostId) { this.jobPostId = jobPostId; }

    public String getResumeUrl() { return resumeUrl; }
    public void setResumeUrl(String resumeUrl) { this.resumeUrl = resumeUrl; }

    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }

    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Boolean getShortlisted() { return shortlisted; }
    public void setShortlisted(Boolean shortlisted) { this.shortlisted = shortlisted; }

    public Boolean getInterviewScheduled() { return interviewScheduled; }
    public void setInterviewScheduled(Boolean interviewScheduled) { this.interviewScheduled = interviewScheduled; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}