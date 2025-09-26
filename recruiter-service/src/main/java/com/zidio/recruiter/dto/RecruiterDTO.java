package com.zidio.recruiter.dto;

import com.zidio.recruiter.enums.RecruiterStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RecruiterDTO {
    private Long id;

    @NotBlank @Size(max = 60)
    private String firstName;

    @NotBlank @Size(max = 60)
    private String lastName;

    @Email @NotBlank @Size(max = 120)
    private String email;

    @Size(max = 20)
    private String phone;

    @Size(max = 120)
    private String company;

    @Size(max = 80)
    private String designation;

    @Size(max = 255)
    private String linkedInProfile;

    private RecruiterStatus status = RecruiterStatus.ACTIVE;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String v) { this.firstName = v; }

    public String getLastName() { return lastName; }
    public void setLastName(String v) { this.lastName = v; }

    public String getEmail() { return email; }
    public void setEmail(String v) { this.email = v; }

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
}
