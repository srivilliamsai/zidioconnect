package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.SystemUserDTO;
import com.zidio.zidioconnect.enums.Role;
import com.zidio.zidioconnect.service.SystemUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system-users")
public class SystemUserController {

    @Autowired
    private SystemUserService service;

    @PostMapping("/create")
    public SystemUserDTO createUser(@RequestBody SystemUserDTO dto) {
        return service.createUser(dto);
    }

    @PostMapping("/register")
    public SystemUserDTO register(@RequestBody SystemUserDTO dto, @RequestParam String password) {
        return service.createSystemUser(dto, password);
    }

    @GetMapping
    public List<SystemUserDTO> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public SystemUserDTO getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public SystemUserDTO update(@PathVariable Long id, @RequestBody SystemUserDTO dto) {
        return service.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/role/{role}")
    public List<SystemUserDTO> getByRole(@PathVariable Role role) {
        return service.getUsersByRole(role);
    }

    @PutMapping("/deactivate/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateUser(id);
    }
}
