package com.zidio.jobpost.controller;

import com.zidio.jobpost.dto.JobPostDTO;
import com.zidio.jobpost.enums.JobStatus;
import com.zidio.jobpost.enums.JobType;
import com.zidio.jobpost.service.JobPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobposts")
@Validated
public class JobPostController {

    private final JobPostService service;

    public JobPostController(JobPostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JobPostDTO> create(@Valid @RequestBody JobPostDTO dto) {
        JobPostDTO saved = service.create(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPostDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<Page<JobPostDTO>> list(@RequestParam(defaultValue = "") String q,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.list(q, PageRequest.of(page, size)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPostDTO> update(@PathVariable Long id, @Valid @RequestBody JobPostDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<JobPostDTO>> byStatus(@PathVariable JobStatus status) {
        return ResponseEntity.ok(service.listByStatus(status));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<JobPostDTO>> byType(@PathVariable JobType type) {
        return ResponseEntity.ok(service.listByType(type));
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobPostDTO>> search(@RequestParam String company) {
        return ResponseEntity.ok(service.searchCompany(company));
    }
}