package com.zidio.admin.controller;

import com.zidio.admin.dto.AdminDTO;
import com.zidio.admin.service.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/admin")
@Validated
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping
    public AdminDTO create(@Valid @RequestBody AdminDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public AdminDTO get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public Page<AdminDTO> list(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) {
        return service.list(PageRequest.of(page, size));
    }

    @PutMapping("/{id}")
    public AdminDTO update(@PathVariable Long id, @RequestBody AdminDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}