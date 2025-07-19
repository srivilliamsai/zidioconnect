package com.zidio.zidioconnect.dto;

public class EmailRequest {

    public String to;
    public String subject;
    public String body;

    public EmailRequest() {
        // Default constructor (important for frameworks like Spring to deserialize JSON)
    }

    public EmailRequest(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
