package com.zidio.zidioconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.zidioconnect.dto.EmailRequest;
import com.zidio.zidioconnect.service.EmailService;

@RestController
@RequestMapping("/api/notify") 
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody EmailRequest request) {
        try {
            emailService.sendEmail(request);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Email sending failed: " + e.getMessage());
        }
    }
}
