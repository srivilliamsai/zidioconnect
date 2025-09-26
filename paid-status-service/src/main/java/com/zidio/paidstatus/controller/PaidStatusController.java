package com.zidio.paidstatus.controller;

import com.zidio.paidstatus.entity.PaidStatus;
import com.zidio.paidstatus.enums.PaymentStatus;
import com.zidio.paidstatus.service.PaidStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/paid-status")
public class PaidStatusController {

    private final PaidStatusService service;

    public PaidStatusController(PaidStatusService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public String ping() { return "paid-status-service OK"; }

    @PostMapping
    public ResponseEntity<PaidStatus> create(@Valid @RequestBody PaidStatus input) {
        return ResponseEntity.ok(service.create(input));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaidStatus> get(@PathVariable Long id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PaidStatus> list(@RequestParam(required = false) String referenceId,
                                 @RequestParam(required = false) Long userId) {
        if (referenceId != null) return service.byReference(referenceId);
        if (userId != null) return service.byUser(userId);
        return service.list();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PaidStatus> updateStatus(@PathVariable Long id,
                                                   @RequestParam PaymentStatus status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
