package com.zidio.zidioconnect.dto;

public class StudentDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String qualification;
    private String resumeURL;
    private String address;
    private String linkedInProfile;

    public StudentDTO() {}

    public StudentDTO(Long id, String name, String email, String phone, String qualification,
                      String resumeURL, String address, String linkedInProfile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualification = qualification;
        this.resumeURL = resumeURL;
        this.address = address;
        this.linkedInProfile = linkedInProfile;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public String getResumeURL() { return resumeURL; }
    public void setResumeURL(String resumeURL) { this.resumeURL = resumeURL; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getLinkedInProfile() { return linkedInProfile; }
    public void setLinkedInProfile(String linkedInProfile) { this.linkedInProfile = linkedInProfile; }
}