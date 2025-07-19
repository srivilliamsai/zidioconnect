package com.zidio.zidioconnect.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.dto.RecruiterDTO;
import com.zidio.zidioconnect.entity.Recruiter;
import com.zidio.zidioconnect.repository.RecruiterRepository;
import com.zidio.zidioconnect.service.RecruiterService;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Override
    public RecruiterDTO createRecruiter(RecruiterDTO recruiterDTO) {
        Recruiter recruiter = convertToEntity(recruiterDTO);
        Recruiter savedRecruiter = recruiterRepository.save(recruiter);
        return convertToDTO(savedRecruiter);
    }

    @Override
    public RecruiterDTO getRecruiterById(Long id) {
        Optional<Recruiter> recruiter = recruiterRepository.findById(id);
        return recruiter.map(this::convertToDTO)
                        .orElseThrow(() -> new RuntimeException("Recruiter not found with id: " + id));
    }

    @Override
    public List<RecruiterDTO> getAllRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        return recruiters.stream()
                         .map(this::convertToDTO)
                         .collect(Collectors.toList());
    }

    @Override
    public RecruiterDTO updateRecruiter(Long id, RecruiterDTO recruiterDTO) {
        Recruiter existing = recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found with id: " + id));

        existing.setName(recruiterDTO.getName());
        existing.setEmail(recruiterDTO.getEmail());
        existing.setPhone(recruiterDTO.getPhone());
        existing.setCompanyName(recruiterDTO.getCompanyName());
        existing.setCompanyDescription(recruiterDTO.getCompanyDescription());
        existing.setCompanyWebsite(recruiterDTO.getCompanyWebsite());

        Recruiter updated = recruiterRepository.save(existing);
        return convertToDTO(updated);
    }

    @Override
    public void deleteRecruiter(Long id) {
        recruiterRepository.deleteById(id);
    }

    @Override
    public RecruiterDTO searchByEmail(String email) {
        Recruiter recruiter = recruiterRepository.findByEmail(email);
        if (recruiter == null) {
            throw new RuntimeException("Recruiter not found with email: " + email);
        }
        return convertToDTO(recruiter);
    }

    @Override
    public List<RecruiterDTO> searchByCompanyName(String companyName) {
        List<Recruiter> recruiters = recruiterRepository.findByCompanyNameContainingIgnoreCase(companyName);
        return recruiters.stream()
                         .map(this::convertToDTO)
                         .collect(Collectors.toList());
    }

    // ======================
    // Conversion methods
    // ======================
    private RecruiterDTO convertToDTO(Recruiter recruiter) {
        return new RecruiterDTO(
                recruiter.getId(),
                recruiter.getName(),
                recruiter.getEmail(),
                recruiter.getPhone(),
                recruiter.getCompanyName(),
                recruiter.getCompanyDescription(),
                recruiter.getCompanyWebsite()
        );
    }

    private Recruiter convertToEntity(RecruiterDTO dto) {
        return new Recruiter(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getCompanyName(),
                dto.getCompanyDescription(),
                dto.getCompanyWebsite()
        );
    }
}