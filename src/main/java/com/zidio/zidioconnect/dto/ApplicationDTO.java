package com.zidio.zidioconnect.dto;

import com.zidio.zidioconnect.enums.Status;
import java.util.Date;

public class ApplicationDTO {

    private Long id;
    private Long studentId;
    private Long jobId;  // we pass jobPost id here
    private String resumeURL;
    private Status status;
    private Date appliedDate;
    private String feedback;
    private boolean shortlisted;
    private boolean interviewScheduled;
    private Date updatedAt;

    public ApplicationDTO() {
    }

    public ApplicationDTO(Long id, Long studentId, Long jobId, String resumeURL, Status status,
                          Date appliedDate, String feedback, boolean shortlisted,
                          boolean interviewScheduled, Date updatedAt) {
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

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getResumeURL() { return resumeURL; }
    public void setResumeURL(String resumeURL) { this.resumeURL = resumeURL; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Date getAppliedDate() { return appliedDate; }
    public void setAppliedDate(Date appliedDate) { this.appliedDate = appliedDate; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public boolean isShortlisted() { return shortlisted; }
    public void setShortlisted(boolean shortlisted) { this.shortlisted = shortlisted; }

    public boolean isInterviewScheduled() { return interviewScheduled; }
    public void setInterviewScheduled(boolean interviewScheduled) { this.interviewScheduled = interviewScheduled; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
