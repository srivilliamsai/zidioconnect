package com.zidio.analytics.service.impl;

import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

@Service
public class MetricsService {
    private final AtomicLong totalStudents = new AtomicLong(0);
    private final AtomicLong totalJobPosts = new AtomicLong(0);
    private final AtomicLong totalApplications = new AtomicLong(0);

    public void incStudents(){ totalStudents.incrementAndGet(); }
    public void incJobPosts(){ totalJobPosts.incrementAndGet(); }
    public void incApplications(){ totalApplications.incrementAndGet(); }

    public Map<String, Long> snapshot(){
        Map<String, Long> m = new LinkedHashMap<>();
        m.put("students", totalStudents.get());
        m.put("jobPosts", totalJobPosts.get());
        m.put("applications", totalApplications.get());
        return m;
    }
}
