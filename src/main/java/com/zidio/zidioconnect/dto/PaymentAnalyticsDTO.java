package com.zidio.zidioconnect.dto;

public class PaymentAnalyticsDTO {
    private long paidCount;
    private long unpaidCount;

    public PaymentAnalyticsDTO() {}

    public PaymentAnalyticsDTO(long paidCount, long unpaidCount) {
        this.paidCount = paidCount;
        this.unpaidCount = unpaidCount;
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
