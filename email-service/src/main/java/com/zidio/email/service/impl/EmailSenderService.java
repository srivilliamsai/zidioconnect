package com.zidio.email.service.impl;

import com.zidio.email.dto.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    private final JavaMailSender mail;
    public EmailSenderService(JavaMailSender mail){ this.mail = mail; }

    public void send(EmailRequest req){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(req.getTo());
        msg.setSubject(req.getSubject());
        msg.setText(req.getBody());
        mail.send(msg);
    }
}
