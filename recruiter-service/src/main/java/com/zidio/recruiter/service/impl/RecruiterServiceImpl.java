package com.zidio.recruiter.service.impl;

import com.zidio.recruiter.dto.RecruiterDTO;
import com.zidio.recruiter.entity.Recruiter;
import com.zidio.recruiter.mapper.RecruiterMapper;
import com.zidio.recruiter.repository.RecruiterRepository;
import com.zidio.recruiter.service.RecruiterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecruiterServiceImpl implements RecruiterService {

    private final RecruiterRepository repo;
    private final RecruiterMapper mapper; // Injecting the mapper instance

    public RecruiterServiceImpl(RecruiterRepository repo, RecruiterMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public RecruiterDTO get(Long id) {
        // Using explicit lambda to fix method reference compilation error
        return repo.findById(id).map(recruiter -> mapper.toDTO(recruiter)).orElse(null); 
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RecruiterDTO> list(String q, Pageable pageable) {
        Page<Recruiter> page;
        if (q != null && !q.trim().isEmpty()) {
            // Assuming the method is now defined in RecruiterRepository.java
            page = repo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrCompanyContainingIgnoreCase(
                q, q, q, q, pageable 
            );
        } else {
            page = repo.findAll(pageable);
        }
        
        // Using explicit lambda for type safety and to fix compilation error (Line 46)
        return page.map(recruiter -> mapper.toDTO(recruiter)); 
    }
    
    // ... all other methods are now fine ...
    @Override
    public RecruiterDTO update(Long id, RecruiterDTO dto) {
        return repo.findById(id).map(existing -> {
            mapper.copyToEntity(dto, existing);
            return mapper.toDTO(repo.save(existing));
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
    
    @Override
    public RecruiterDTO create(RecruiterDTO dto) {
        Recruiter r = mapper.toEntity(dto);
        r = repo.save(r);
        return mapper.toDTO(r);
    }
}