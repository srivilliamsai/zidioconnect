package com.zidio.recruiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RecruiterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecruiterServiceApplication.class, args);
    }
}