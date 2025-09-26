package com.zidio.payment.entity;

import com.zidio.payment.enums.PaymentStatus;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name="payments")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull private Long studentId;
    private Long jobPostId;

    @NotNull private BigDecimal amount;
    @NotBlank private String currency;
    @NotBlank private String method;       // e.g., CARD, UPI, NETBANKING
    private String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status = PaymentStatus.PENDING;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist public void prePersist(){ createdAt = LocalDateTime.now(); updatedAt = createdAt; }
    @PreUpdate  public void preUpdate(){  updatedAt = LocalDateTime.now(); }
}
