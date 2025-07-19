package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.ApplicationDTO;
import com.zidio.zidioconnect.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @PostMapping
    public ApplicationDTO create(@RequestBody ApplicationDTO dto) {
        return service.createApplication(dto);
    }

    @GetMapping("/{id}")
    public ApplicationDTO getById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }

    @GetMapping
    public List<ApplicationDTO> getAll() {
        return service.getAllApplications();
    }

    @PutMapping("/{id}")
    public ApplicationDTO update(@PathVariable Long id, @RequestBody ApplicationDTO dto) {
        return service.updateApplication(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteApplication(id);
    }
}