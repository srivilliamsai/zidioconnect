package com.zidio.zidioconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.zidioconnect.dto.RecruiterDTO;
import com.zidio.zidioconnect.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping("/register")
    public ResponseEntity<RecruiterDTO> register(@RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(recruiterService.createRecruiter(dto));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<RecruiterDTO> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(recruiterService.getRecruiterByEmail(email));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RecruiterDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(recruiterService.getRecruiterById(id));
    }
}
