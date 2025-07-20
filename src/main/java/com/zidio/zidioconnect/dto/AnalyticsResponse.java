package com.zidio.zidioconnect.dto;

public class AnalyticsResponse {

    private long totalJobs;
    private long activeJobs;
    private long inactiveJobs;
    private long filledJobs;
    private long closedJobs;

    private long totalPayments;
    private long paidCount;
    private long unpaidCount;

    public AnalyticsResponse() {}

    public AnalyticsResponse(long totalJobs, long activeJobs, long inactiveJobs, long filledJobs, long closedJobs,
                             long totalPayments, long paidCount, long unpaidCount) {
        this.totalJobs = totalJobs;
        this.activeJobs = activeJobs;
        this.inactiveJobs = inactiveJobs;
        this.filledJobs = filledJobs;
        this.closedJobs = closedJobs;
        this.totalPayments = totalPayments;
        this.paidCount = paidCount;
        this.unpaidCount = unpaidCount;
    }

    // Getters and Setters

    public long getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(long totalJobs) {
        this.totalJobs = totalJobs;
    }

    public long getActiveJobs() {
        return activeJobs;
    }

    public void setActiveJobs(long activeJobs) {
        this.activeJobs = activeJobs;
    }

    public long getInactiveJobs() {
        return inactiveJobs;
    }

    public void setInactiveJobs(long inactiveJobs) {
        this.inactiveJobs = inactiveJobs;
    }

    public long getFilledJobs() {
        return filledJobs;
    }

    public void setFilledJobs(long filledJobs) {
        this.filledJobs = filledJobs;
    }

    public long getClosedJobs() {
        return closedJobs;
    }

    public void setClosedJobs(long closedJobs) {
        this.closedJobs = closedJobs;
    }

    public long getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(long totalPayments) {
        this.totalPayments = totalPayments;
    }

    public long getPaidCount() {
        return paidCount;
    }

    public void setPaidCount(long paidCount) {
        this.paidCount = paidCount;
    }

    public long getUnpaidCount() {
        return unpaidCount;
    }

    public void setUnpaidCount(long unpaidCount) {
        this.unpaidCount = unpaidCount;
    }
}
