package com.zidio.notification.service.impl;

import com.zidio.notification.entity.Notification;
import com.zidio.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NotificationServiceImpl {
    private final NotificationRepository repo;
    public NotificationServiceImpl(NotificationRepository repo){ this.repo = repo; }

    public Notification create(Notification n){ return repo.save(n); }
    public List<Notification> list(){ return repo.findAll(); }
}
