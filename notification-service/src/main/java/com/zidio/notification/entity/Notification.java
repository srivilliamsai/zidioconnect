package com.zidio.notification.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name="notifications")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email @NotBlank private String recipientEmail;
    @NotBlank private String subject;
    @NotBlank @Column(length = 4000) private String message;

    private boolean sent = false;
    private LocalDateTime createdAt;

    @PrePersist public void pre(){ createdAt = LocalDateTime.now(); }
}
