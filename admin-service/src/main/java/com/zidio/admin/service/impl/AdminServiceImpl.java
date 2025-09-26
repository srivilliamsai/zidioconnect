package com.zidio.admin.service.impl;

import com.zidio.admin.dto.AdminDTO;
import com.zidio.admin.entity.Admin;
import com.zidio.admin.mapper.AdminMapper;
import com.zidio.admin.repository.AdminRepository;
import com.zidio.admin.service.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repo;

    public AdminServiceImpl(AdminRepository repo) {
        this.repo = repo;
    }

    @Override
    public AdminDTO create(AdminDTO dto) {
        if (repo.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already used: " + dto.getEmail());
        }
        Admin a = AdminMapper.toEntity(dto);
        a = repo.save(a);
        return AdminMapper.toDTO(a);
    }

    @Override
    @Transactional(readOnly = true)
    public AdminDTO get(Long id) {
        Admin a = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin not found: " + id));
        return AdminMapper.toDTO(a);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdminDTO> list(Pageable pageable) {
        Page<Admin> page = repo.findAll(pageable);
        return new PageImpl<>(
                page.getContent().stream().map(AdminMapper::toDTO).collect(Collectors.toList()),
                pageable,
                page.getTotalElements()
        );
    }

    @Override
    public AdminDTO update(Long id, AdminDTO dto) {
        Admin a = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin not found: " + id));
        AdminMapper.copy(dto, a);
        a = repo.save(a);
        return AdminMapper.toDTO(a);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) return;
        repo.deleteById(id);
    }
}
