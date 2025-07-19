package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.JobPostDTO;
import com.zidio.zidioconnect.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @PostMapping
    public ResponseEntity<JobPostDTO> createJob(@RequestBody JobPostDTO jobPostDTO) {
        return ResponseEntity.ok(jobPostService.createJobPost(jobPostDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPostDTO> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobPostService.getJobPostById(id));
    }

    @GetMapping
    public ResponseEntity<List<JobPostDTO>> getAllJobs() {
        return ResponseEntity.ok(jobPostService.getAllJobPosts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPostDTO> updateJob(@PathVariable Long id, @RequestBody JobPostDTO jobPostDTO) {
        return ResponseEntity.ok(jobPostService.updateJobPost(id, jobPostDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobPostService.deleteJobPost(id);
        return ResponseEntity.ok("Job deleted successfully!");
    }
}