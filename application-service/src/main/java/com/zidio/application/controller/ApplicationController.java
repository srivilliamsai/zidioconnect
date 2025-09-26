package com.zidio.application.controller;

import com.zidio.application.dto.ApplicationDTO;
import com.zidio.application.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApplicationDTO> create(@RequestBody ApplicationDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> update(@PathVariable Long id, @RequestBody ApplicationDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> list(
            @RequestParam(required = false) Long studentId,
            @RequestParam(required = false) Long jobPostId) {

        List<ApplicationDTO> list = service.list();

        if (studentId != null) {
            list = list.stream()
                    .filter(a -> studentId.equals(a.getStudentId()))
                    .collect(Collectors.toList());
        }
        if (jobPostId != null) {
            list = list.stream()
                    .filter(a -> jobPostId.equals(a.getJobPostId()))
                    .collect(Collectors.toList());
        }
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}