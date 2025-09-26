package com.zidio.email.controller;

import com.zidio.email.dto.EmailRequest;
import com.zidio.email.service.impl.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequestMapping("/api/email")
@Validated
public class EmailController {
    private final EmailSenderService sender;
    public EmailController(EmailSenderService sender){ this.sender = sender; }

    @PostMapping("/send")
    public ResponseEntity<String> send(@Valid @RequestBody EmailRequest req){
        sender.send(req);
        return ResponseEntity.ok("SENT");
    }
}
