package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.UserPaymentStatusDTO;
import com.zidio.zidioconnect.service.UserPaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class UserPaymentStatusController {

    @Autowired
    private UserPaymentStatusService service;

    @PostMapping
    public UserPaymentStatusDTO create(@RequestBody UserPaymentStatusDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<UserPaymentStatusDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserPaymentStatusDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public UserPaymentStatusDTO update(@PathVariable Long id, @RequestBody UserPaymentStatusDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}