package com.zidio.application.mapper;

import com.zidio.application.dto.ApplicationDTO;
import com.zidio.application.entity.Application;

public class ApplicationMapper {

    public static ApplicationDTO toDTO(Application e) {
        if (e == null) return null;
        ApplicationDTO d = new ApplicationDTO();
        d.setId(e.getId());
        d.setStudentId(e.getStudentId());
        d.setJobPostId(e.getJobPostId());
        d.setResumeUrl(e.getResumeUrl());
        d.setCoverLetter(e.getCoverLetter());
        d.setStatus(e.getStatus());
        d.setFeedback(e.getFeedback());
        d.setShortlisted(e.isShortlisted());
        d.setInterviewScheduled(e.isInterviewScheduled());
        d.setCreatedAt(e.getCreatedAt());
        d.setUpdatedAt(e.getUpdatedAt());
        return d;
        }

    public static Application toEntity(ApplicationDTO d) {
        if (d == null) return null;
        Application e = new Application();
        e.setId(d.getId());
        e.setStudentId(d.getStudentId());
        e.setJobPostId(d.getJobPostId());
        e.setResumeUrl(d.getResumeUrl());
        e.setCoverLetter(d.getCoverLetter());
        e.setStatus(d.getStatus());
        e.setFeedback(d.getFeedback());
        e.setShortlisted(Boolean.TRUE.equals(d.getShortlisted()));
        e.setInterviewScheduled(Boolean.TRUE.equals(d.getInterviewScheduled()));
        e.setCreatedAt(d.getCreatedAt());
        e.setUpdatedAt(d.getUpdatedAt());
        return e;
    }

    public static void copyNonNull(ApplicationDTO d, Application e) {
        if (d.getStudentId() != null) e.setStudentId(d.getStudentId());
        if (d.getJobPostId() != null) e.setJobPostId(d.getJobPostId());
        if (d.getResumeUrl() != null) e.setResumeUrl(d.getResumeUrl());
        if (d.getCoverLetter() != null) e.setCoverLetter(d.getCoverLetter());
        if (d.getStatus() != null) e.setStatus(d.getStatus());
        if (d.getFeedback() != null) e.setFeedback(d.getFeedback());
        if (d.getShortlisted() != null) e.setShortlisted(d.getShortlisted());
        if (d.getInterviewScheduled() != null) e.setInterviewScheduled(d.getInterviewScheduled());
        if (d.getCreatedAt() != null) e.setCreatedAt(d.getCreatedAt());
        if (d.getUpdatedAt() != null) e.setUpdatedAt(d.getUpdatedAt());
    }
}