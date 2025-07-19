package com.zidio.zidioconnect.entity;

import java.time.LocalDate;
import javax.persistence.*;

import com.zidio.zidioconnect.enums.PaidStatus;

@Entity
@Table(name = "user_payment_status")
public class UserPaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ADDED

    private Long planId; // ADDED
    private Long userId; // ADDED
    private LocalDate subscriptionStart; // ADDED
    private LocalDate subscriptionEnd; // ADDED

    @Enumerated(EnumType.STRING)
    private PaidStatus status; // ADDED

    // Constructors
    public UserPaymentStatus() {} // ADDED

    public UserPaymentStatus(Long id, Long planId, Long userId, LocalDate subscriptionStart, LocalDate subscriptionEnd, PaidStatus status) {
        this.id = id;
        this.planId = planId;
        this.userId = userId;
        this.subscriptionStart = subscriptionStart;
        this.subscriptionEnd = subscriptionEnd;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPlanId() { return planId; }
    public void setPlanId(Long planId) { this.planId = planId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDate getSubscriptionStart() { return subscriptionStart; }
    public void setSubscriptionStart(LocalDate subscriptionStart) { this.subscriptionStart = subscriptionStart; }

    public LocalDate getSubscriptionEnd() { return subscriptionEnd; }
    public void setSubscriptionEnd(LocalDate subscriptionEnd) { this.subscriptionEnd = subscriptionEnd; }

    public PaidStatus getStatus() { return status; }
    public void setStatus(PaidStatus status) { this.status = status; }
}