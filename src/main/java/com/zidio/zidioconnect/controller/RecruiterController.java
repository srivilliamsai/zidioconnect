package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.RecruiterDTO;
import com.zidio.zidioconnect.service.RecruiterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    // Create a recruiter
    @PostMapping
    public ResponseEntity<RecruiterDTO> createRecruiter(@RequestBody RecruiterDTO recruiterDTO) {
        RecruiterDTO created = recruiterService.createRecruiter(recruiterDTO);
        return ResponseEntity.ok(created);
    }

    //  Get recruiter by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecruiterDTO> getRecruiterById(@PathVariable Long id) {
        RecruiterDTO recruiter = recruiterService.getRecruiterById(id);
        return ResponseEntity.ok(recruiter);
    }

    //  Get all recruiters
    @GetMapping
    public ResponseEntity<List<RecruiterDTO>> getAllRecruiters() {
        List<RecruiterDTO> recruiters = recruiterService.getAllRecruiters();
        return ResponseEntity.ok(recruiters);
    }

    // Update recruiter
    @PutMapping("/{id}")
    public ResponseEntity<RecruiterDTO> updateRecruiter(
            @PathVariable Long id,
            @RequestBody RecruiterDTO recruiterDTO) {
        RecruiterDTO updated = recruiterService.updateRecruiter(id, recruiterDTO);
        return ResponseEntity.ok(updated);
    }

    // Delete recruiter
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruiter(@PathVariable Long id) {
        recruiterService.deleteRecruiter(id);
        return ResponseEntity.noContent().build();
    }

    // Search by email
    @GetMapping("/search/email")
    public ResponseEntity<RecruiterDTO> searchByEmail(@RequestParam String email) {
        RecruiterDTO recruiter = recruiterService.searchByEmail(email);
        return ResponseEntity.ok(recruiter);
    }

    // Search by company name (partial match)
    @GetMapping("/search/company")
    public ResponseEntity<List<RecruiterDTO>> searchByCompanyName(@RequestParam String name) {
        List<RecruiterDTO> recruiters = recruiterService.searchByCompanyName(name);
        return ResponseEntity.ok(recruiters);
    }
}