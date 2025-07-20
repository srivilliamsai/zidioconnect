package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.AnalyticsResponse;
import com.zidio.zidioconnect.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping
    public AnalyticsResponse getAnalytics() {
        return analyticsService.getAnalyticsData();
    }
}
