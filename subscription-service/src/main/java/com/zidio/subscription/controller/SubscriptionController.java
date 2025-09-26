package com.zidio.subscription.controller;

import com.zidio.subscription.entity.Subscription;
import com.zidio.subscription.service.impl.SubscriptionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController @RequestMapping("api/subscriptions")
public class SubscriptionController {
    private final SubscriptionServiceImpl service;
    public SubscriptionController(SubscriptionServiceImpl service){ this.service = service; }

    @PostMapping public Subscription create(@Valid @RequestBody Subscription s){ return service.create(s); }
    @GetMapping public List<Subscription> list(@RequestParam(required = false) Long studentId){
        return studentId == null ? service.list() : service.byStudent(studentId);
    }
    @GetMapping("/{id}") public ResponseEntity<Subscription> get(@PathVariable Long id){
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/cancel") public Subscription cancel(@PathVariable Long id){ return service.cancel(id); }
    @PostMapping("/{id}/extend") public Subscription extend(@PathVariable Long id, @RequestParam int days){ return service.extend(id, days); }
}
