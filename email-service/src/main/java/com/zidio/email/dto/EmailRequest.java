package com.zidio.email.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailRequest {
    @Email @NotBlank private String to;
    @NotBlank private String subject;
    @NotBlank private String body;
}
