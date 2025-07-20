package com.zidio.zidioconnect.entity;

import com.zidio.zidioconnect.enums.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;

    //  Updated: Map relationship to JobPost
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private JobPost jobPost;

    private String resumeURL;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date appliedDate;

    private String feedback;

    private boolean shortlisted = false;
    private boolean interviewScheduled = false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    //  Default constructor
    public Application() {
    }

    //  All-args constructor
    public Application(Long id, Long studentId, JobPost jobPost, String resumeURL, Status status,
                       Date appliedDate, String feedback, boolean shortlisted, boolean interviewScheduled,
                       Date updatedAt) {
        this.id = id;
        this.studentId = studentId;
        this.jobPost = jobPost;
        this.resumeURL = resumeURL;
        this.status = status;
        this.appliedDate = appliedDate;
        this.feedback = feedback;
        this.shortlisted = shortlisted;
        this.interviewScheduled = interviewScheduled;
        this.updatedAt = updatedAt;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public JobPost getJobPost() { return jobPost; }
    public void setJobPost(JobPost jobPost) { this.jobPost = jobPost; }

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
