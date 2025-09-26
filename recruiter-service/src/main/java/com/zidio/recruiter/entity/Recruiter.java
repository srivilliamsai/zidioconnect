package com.zidio.recruiter.entity;

import com.zidio.recruiter.enums.RecruiterStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "recruiters", indexes = {
        @Index(name = "idx_recruiter_email", columnList = "email", unique = true)
})
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String firstName;

    @NotBlank @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String lastName;

    @Email @NotBlank @Size(max = 120)
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    // The missing field
    @NotBlank
    @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String password;

    @Size(max = 20)
    private String phone;

    @Size(max = 120)
    private String company;

    @Size(max = 80)
    private String designation;

    @Size(max = 255)
    private String linkedInProfile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RecruiterStatus status = RecruiterStatus.ACTIVE;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Recruiter() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String v) { this.firstName = v; }

    public String getLastName() { return lastName; }
    public void setLastName(String v) { this.lastName = v; }

    public String getEmail() { return email; }
    public void setEmail(String v) { this.email = v; }

    // Getter for password
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String v) { this.phone = v; }

    public String getCompany() { return company; }
    public void setCompany(String v) { this.company = v; }

    public String getDesignation() { return designation; }
    public void setDesignation(String v) { this.designation = v; }

    public String getLinkedInProfile() { return linkedInProfile; }
    public void setLinkedInProfile(String v) { this.linkedInProfile = v; }

    public RecruiterStatus getStatus() { return status; }
    public void setStatus(RecruiterStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}