package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.ApplicationDTO;
import com.zidio.zidioconnect.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<ApplicationDTO> createApplication(@RequestBody ApplicationDTO applicationDTO) {
        ApplicationDTO created = applicationService.createApplication(applicationDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> getApplicationById(@PathVariable Long id) {
        ApplicationDTO applicationDTO = applicationService.getApplicationById(id);
        return ResponseEntity.ok(applicationDTO);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsByStudent(@PathVariable Long studentId) {
        List<ApplicationDTO> list = applicationService.getApplicationsByStudentId(studentId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsByJob(@PathVariable Long jobId) {
        List<ApplicationDTO> list = applicationService.getApplicationsByJobId(jobId);
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> updateApplication(@PathVariable Long id,
                                                            @RequestBody ApplicationDTO applicationDTO) {
        ApplicationDTO updated = applicationService.updateApplication(id, applicationDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
