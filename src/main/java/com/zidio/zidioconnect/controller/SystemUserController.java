package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.SystemUserDTO;
import com.zidio.zidioconnect.entity.SystemUser;
import com.zidio.zidioconnect.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/system-users")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @PostMapping("/create")
    public ResponseEntity<SystemUserDTO> createUser(@RequestBody SystemUserDTO dto,
                                                    @RequestParam String password) {
        return ResponseEntity.ok(systemUserService.createSystemUser(dto, password));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SystemUserDTO>> getAllUsers() {
        return ResponseEntity.ok(systemUserService.getAllSystemUsers());
    }

    @GetMapping("/email")
    public ResponseEntity<SystemUser> getByEmail(@RequestParam String email) {
        Optional<SystemUser> user = systemUserService.getByEmail(email);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateUser(@PathVariable Long id) {
        systemUserService.deactivateUser(id);
        return ResponseEntity.ok("User deactivated successfully");
    }
}