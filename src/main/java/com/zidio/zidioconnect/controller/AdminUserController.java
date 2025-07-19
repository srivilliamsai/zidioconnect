package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.AdminUserDTO;
import com.zidio.zidioconnect.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adminUsers")
public class AdminUserController {

    @Autowired
    private AdminUserService adminService;

    @PostMapping
    public AdminUserDTO create(@RequestBody AdminUserDTO dto) {
        return adminService.createAdmin(dto);
    }

    @GetMapping
    public List<AdminUserDTO> getAll() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdminUserDTO getById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public AdminUserDTO update(@PathVariable Long id, @RequestBody AdminUserDTO dto) {
        return adminService.updateAdmin(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
}