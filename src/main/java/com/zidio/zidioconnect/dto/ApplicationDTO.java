package com.zidio.zidioconnect.dto;

import java.util.Date;
import com.zidio.zidioconnect.enums.Status;

public class ApplicationDTO {

    private Long id;
    private Long studentId;
    private Long jobId;
    private String resumeURL;
    private Status status;
    private Date appliedDate;

    public ApplicationDTO() {
    }

    public ApplicationDTO(Long id, Long studentId, Long jobId, String resumeURL, Status status, Date appliedDate) {
        this.id = id;
        this.studentId = studentId;
        this.jobId = jobId;
        this.resumeURL = resumeURL;
        this.status = status;
        this.appliedDate = appliedDate;
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

    @Override
    public String toString() {
        return "ApplicationDTO{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", jobId=" + jobId +
                ", resumeURL='" + resumeURL + '\'' +
                ", status=" + status +
                ", appliedDate=" + appliedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationDTO)) return false;

        ApplicationDTO that = (ApplicationDTO) o;

        if (!id.equals(that.id)) return false;
        if (!studentId.equals(that.studentId)) return false;
        if (!jobId.equals(that.jobId)) return false;
        if (!resumeURL.equals(that.resumeURL)) return false;
        if (status != that.status) return false;
        return appliedDate.equals(that.appliedDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + studentId.hashCode();
        result = 31 * result + jobId.hashCode();
        result = 31 * result + resumeURL.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + appliedDate.hashCode();
        return result;
    }
}