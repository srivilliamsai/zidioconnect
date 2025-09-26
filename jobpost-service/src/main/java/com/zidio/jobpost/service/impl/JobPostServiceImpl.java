package com.zidio.jobpost.service.impl;

import com.zidio.jobpost.dto.JobPostDTO;
import com.zidio.jobpost.entity.JobPost;
import com.zidio.jobpost.enums.JobStatus;
import com.zidio.jobpost.enums.JobType;
import com.zidio.jobpost.mapper.JobPostMapper;
import com.zidio.jobpost.repository.JobPostRepository;
import com.zidio.jobpost.service.JobPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobPostServiceImpl implements JobPostService {

    private final JobPostRepository repo;
    private final JobPostMapper mapper;

    public JobPostServiceImpl(JobPostRepository repo, JobPostMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public JobPostDTO create(JobPostDTO dto) {
        JobPost entity = mapper.toEntity(dto);
        if (entity.getStatus() == null) {
            entity.setStatus(JobStatus.OPEN);
        }
        return mapper.toDTO(repo.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public JobPostDTO get(Long id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<JobPostDTO> list(String q, Pageable pageable) {
        Page<JobPost> page;
        if (q != null && !q.trim().isEmpty()) {
            page = repo.findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCase(q, q, pageable);
        } else {
            page = repo.findAll(pageable);
        }
        List<JobPostDTO> dtoList = page.getContent().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, page.getTotalElements());
    }

    @Override
    public JobPostDTO update(Long id, JobPostDTO dto) {
        return repo.findById(id)
                .map(existing -> {
                    mapper.copyToEntity(dto, existing);
                    return mapper.toDTO(repo.save(existing));
                }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        if (repo.existsById(id)) repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JobPostDTO> listByStatus(JobStatus status) {
        return repo.findByStatus(status).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<JobPostDTO> listByType(JobType type) {
        return repo.findByJobType(type).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<JobPostDTO> searchCompany(String company) {
        return repo.findByCompanyContainingIgnoreCase(company).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}