package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.JobPostDTO;
import com.zidio.zidioconnect.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobposts")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @PostMapping
    public JobPostDTO create(@RequestBody JobPostDTO dto) {
        return jobPostService.createJobPost(dto);
    }

    @GetMapping("/{id}")
    public JobPostDTO getById(@PathVariable Long id) {
        return jobPostService.getJobPostById(id);
    }

    @GetMapping
    public List<JobPostDTO> getAll() {
        return jobPostService.getAllJobPosts();
    }

    @PutMapping("/{id}")
    public JobPostDTO update(@PathVariable Long id, @RequestBody JobPostDTO dto) {
        return jobPostService.updateJobPost(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jobPostService.deleteJobPost(id);
    }
}