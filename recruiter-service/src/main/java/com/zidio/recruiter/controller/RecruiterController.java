package com.zidio.recruiter.controller;

import com.zidio.recruiter.dto.RecruiterDTO;
import com.zidio.recruiter.service.RecruiterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity; // Add this import
import org.springframework.security.access.prepost.PreAuthorize; // Add this import
import org.springframework.validation.annotation.Validated; // Add this import
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    private final RecruiterService service;

    public RecruiterController(RecruiterService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_RECRUITER')") // Add this
    public ResponseEntity<RecruiterDTO> create(@Valid @RequestBody RecruiterDTO dto) {
        RecruiterDTO saved = service.create(dto);
        return ResponseEntity.created(URI.create("/api/recruiters/" + saved.getId())).body(saved);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_RECRUITER')") // Add this
    public ResponseEntity<RecruiterDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_RECRUITER')") // Add this
    public ResponseEntity<Page<RecruiterDTO>> list(@RequestParam(defaultValue = "") String q,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.list(q, PageRequest.of(page, size)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_RECRUITER')") // Add this
    public ResponseEntity<RecruiterDTO> update(@PathVariable Long id, @Valid @RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_RECRUITER')") // Add this
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}