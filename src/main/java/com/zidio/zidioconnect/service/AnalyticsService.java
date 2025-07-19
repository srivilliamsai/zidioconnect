package com.zidio.zidioconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zidio.zidioconnect.dto.AnalyticsResponse;

@Service
public class AnalyticsService {

    @Autowired
    private RestTemplate restTemplate;

    public AnalyticsResponse collectData() {
        Long students = restTemplate.getForObject("http://student-service/internal/count", Long.class);
        Long recruiters = restTemplate.getForObject("http://recruiter-service/internal/count", Long.class);
        Long jobPosts = restTemplate.getForObject("http://jobPost-service/internal/count", Long.class);
        Long applications = restTemplate.getForObject("http://application-service/internal/count", Long.class);
        Long admins = restTemplate.getForObject("http://admin-service/internal/count", Long.class);
        String email = restTemplate.getForObject("http://email-service/internal/count", String.class);
        String fileUpload = restTemplate.getForObject("http://file-service/internal/count", String.class); // assumed

        return new AnalyticsResponse(students, recruiters, jobPosts, applications, admins, fileUpload, email);
    }
}
