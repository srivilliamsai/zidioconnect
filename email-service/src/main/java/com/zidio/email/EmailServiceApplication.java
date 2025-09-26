package com.zidio.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zidio.email"})
public class EmailServiceApplication {
    public static void main(String[] args) { SpringApplication.run(EmailServiceApplication.class, args); }
}
