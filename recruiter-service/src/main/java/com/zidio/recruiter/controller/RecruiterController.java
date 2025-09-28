package com.zidio.recruiter.controller;

import com.zidio.recruiter.dto.RecruiterDTO;
import com.zidio.recruiter.service.RecruiterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize; // Keep this import
import org.springframework.validation.annotation.Validated;
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
    @PreAuthorize("hasAuthority('ROLE_RECRUITER')") // Changed to hasAuthority
    public ResponseEntity<RecruiterDTO> create(@Valid @RequestBody RecruiterDTO dto) {
        RecruiterDTO saved = service.create(dto);
        return ResponseEntity.created(URI.create("/api/recruiters/" + saved.getId())).body(saved);
    }
    // ... all other methods should use @PreAuthorize("hasAuthority('ROLE_RECRUITER')")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_RECRUITER')") 
    public ResponseEntity<RecruiterDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_RECRUITER')") 
    public ResponseEntity<Page<RecruiterDTO>> list(@RequestParam(defaultValue = "") String q,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.list(q, PageRequest.of(page, size)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_RECRUITER')") 
    public ResponseEntity<RecruiterDTO> update(@PathVariable Long id, @Valid @RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_RECRUITER')") 
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}