package com.zidio.recruiter.service.impl;

import com.zidio.recruiter.dto.RecruiterDTO;
import com.zidio.recruiter.entity.Recruiter;
import com.zidio.recruiter.mapper.RecruiterMapper;
import com.zidio.recruiter.repository.RecruiterRepository;
import com.zidio.recruiter.service.RecruiterService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RecruiterServiceImpl implements RecruiterService {

    private final RecruiterRepository repo;

    public RecruiterServiceImpl(RecruiterRepository repo) {
        this.repo = repo;
    }

    @Override
    public RecruiterDTO create(RecruiterDTO dto) {
        Recruiter r = RecruiterMapper.toEntity(dto);
        r = repo.save(r);
        return RecruiterMapper.toDTO(r);
    }

    @Override
    @Transactional(readOnly = true)
    public RecruiterDTO get(Long id) {
        return repo.findById(id).map(RecruiterMapper::toDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RecruiterDTO> list(String q, Pageable pageable) {
        if (pageable == null) pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Page<Recruiter> page = repo.findAll((root, cq, cb) -> {
            List<Predicate> ps = new ArrayList<>();
            if (q != null && !q.trim().isEmpty()) {
                String like = "%" + q.trim().toLowerCase() + "%";
                ps.add(cb.or(
                        cb.like(cb.lower(root.get("firstName")), like),
                        cb.like(cb.lower(root.get("lastName")), like),
                        cb.like(cb.lower(root.get("email")), like),
                        cb.like(cb.lower(root.get("company")), like)
                ));
            }
            return cb.and(ps.toArray(new Predicate[0]));
        }, pageable);
        return page.map(RecruiterMapper::toDTO);
    }

    @Override
    public RecruiterDTO update(Long id, RecruiterDTO dto) {
        return repo.findById(id).map(existing -> {
            RecruiterMapper.copyToEntity(dto, existing);
            return RecruiterMapper.toDTO(repo.save(existing));
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
}
