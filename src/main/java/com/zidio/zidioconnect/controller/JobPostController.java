package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.JobPostDTO;
import com.zidio.zidioconnect.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-posts")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @PostMapping
    public JobPostDTO createJobPost(@RequestBody JobPostDTO jobPostDTO) {
        return jobPostService.createJobPost(jobPostDTO);
    }

    @GetMapping("/{id}")
    public JobPostDTO getJobPostById(@PathVariable Long id) {
        return jobPostService.getJobPostById(id);
    }

    @GetMapping
    public List<JobPostDTO> getAllJobPosts() {
        return jobPostService.getAllJobPosts();
    }

    @PutMapping("/{id}")
    public JobPostDTO updateJobPost(@PathVariable Long id, @RequestBody JobPostDTO jobPostDTO) {
        return jobPostService.updateJobPost(id, jobPostDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteJobPost(@PathVariable Long id) {
        jobPostService.deleteJobPost(id);
    }
}
