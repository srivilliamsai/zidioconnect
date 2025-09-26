package com.zidio.subscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zidio.subscription"})
public class SubscriptionServiceApplication {
    public static void main(String[] args) { SpringApplication.run(SubscriptionServiceApplication.class, args); }
}
