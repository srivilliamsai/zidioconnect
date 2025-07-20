package com.zidio.zidioconnect.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmailRequest {

    @NotBlank(message = "Recipient email is required")
    @Email(message = "Invalid recipient email format")
    private String to;

    @NotBlank(message = "Subject is required")
    private String subject;

    @NotBlank(message = "Email body is required")
    private String body;

    // ✅ Constructors
    public EmailRequest() {}

    public EmailRequest(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    // ✅ Getters and Setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
