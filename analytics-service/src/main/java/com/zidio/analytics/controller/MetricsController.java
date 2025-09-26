package com.zidio.analytics.controller;

import com.zidio.analytics.service.impl.MetricsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController @RequestMapping("/api/analytics")
public class MetricsController {
    private final MetricsService service;
    public MetricsController(MetricsService service){ this.service = service; }

    @GetMapping("/metrics")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Map<String, Long>> getMetrics(){
        return ResponseEntity.ok(service.snapshot());
    }

    @PostMapping("/students/inc")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> incStudents(){
        service.incStudents();
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/jobposts/inc")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> incJobPosts(){
        service.incJobPosts();
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/applications/inc")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> incApps(){
        service.incApplications();
        return ResponseEntity.ok().build();
    }
}