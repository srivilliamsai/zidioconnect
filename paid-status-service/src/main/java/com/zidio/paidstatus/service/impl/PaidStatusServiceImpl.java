package com.zidio.paidstatus.service.impl;

import com.zidio.paidstatus.entity.PaidStatus;
import com.zidio.paidstatus.enums.PaymentStatus;
import com.zidio.paidstatus.repository.PaidStatusRepository;
import com.zidio.paidstatus.service.PaidStatusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaidStatusServiceImpl implements PaidStatusService {

    private final PaidStatusRepository repo;

    public PaidStatusServiceImpl(PaidStatusRepository repo) {
        this.repo = repo;
    }

    @Override
    public PaidStatus create(PaidStatus input) {
        return repo.save(input);
    }

    @Override
    public Optional<PaidStatus> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<PaidStatus> list() {
        return repo.findAll();
    }

    @Override
    public List<PaidStatus> byReference(String referenceId) {
        return repo.findByReferenceId(referenceId);
    }

    @Override
    public List<PaidStatus> byUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public PaidStatus updateStatus(Long id, PaymentStatus status) {
        PaidStatus ps = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("PaidStatus not found: " + id));
        ps.setStatus(status);
        return repo.save(ps);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
