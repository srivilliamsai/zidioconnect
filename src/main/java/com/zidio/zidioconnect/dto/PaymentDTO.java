package com.zidio.zidioconnect.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.zidio.zidioconnect.enums.PaymentStatus;
import com.zidio.zidioconnect.enums.PaymentType;

public class PaymentDTO {

    private Long id;
    private Long userId;
    private Long planId;
    private String transactionId;
    private BigDecimal amount;
    private String currency;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private LocalDateTime paymentDate;
    
    
	public Long getId() {
		return id;
	}
	public Long getUserId() {
		return userId;
	}
	public Long getPlanId() {
		return planId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

}

