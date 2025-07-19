package com.zidio.zidioconnect.dto;

public class AnalyticsResponse {

    public Long totalStudents;
    public Long totalRecruiters;
    public Long totalJobPosts;
    public Long totalApplications;
    public Long totalAdmins;
    public String totalFileUpload;
    public String totalEmails;

    public AnalyticsResponse() {}

    public AnalyticsResponse(Long totalStudents, Long totalRecruiters, Long totalJobPosts, Long totalApplications, Long totalAdmins, String totalFileUpload, String totalEmails) {
        this.totalStudents = totalStudents;
        this.totalRecruiters = totalRecruiters;
        this.totalJobPosts = totalJobPosts;
        this.totalApplications = totalApplications;
        this.totalAdmins = totalAdmins;
        this.totalFileUpload = totalFileUpload;
        this.totalEmails = totalEmails;
    }

}
