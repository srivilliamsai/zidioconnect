package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest request);
}
