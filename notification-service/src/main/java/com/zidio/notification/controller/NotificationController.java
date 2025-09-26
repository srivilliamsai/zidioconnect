package com.zidio.notification.controller;

import com.zidio.notification.entity.Notification;
import com.zidio.notification.service.impl.NotificationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController @RequestMapping("api/notifications")
public class NotificationController {
    private final NotificationServiceImpl service;
    public NotificationController(NotificationServiceImpl service){ this.service = service; }

    @PostMapping public Notification create(@Valid @RequestBody Notification n){ return service.create(n); }
    @GetMapping  public List<Notification> list(){ return service.list(); }
    @GetMapping("/{id}") public ResponseEntity<Notification> get(@PathVariable Long id){
        return service.list().stream().filter(n -> n.getId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
