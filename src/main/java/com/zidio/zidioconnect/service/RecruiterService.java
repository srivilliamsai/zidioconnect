package com.zidio.zidioconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.dto.RecruiterDTO;
import com.zidio.zidioconnect.entity.Recruiter;
import com.zidio.zidioconnect.repository.RecruiterRepository;

@Service
public class RecruiterService {
    
    @Autowired 
    private RecruiterRepository recruiterRepository;

    public RecruiterDTO createRecruiter(RecruiterDTO dto) {
        Recruiter recruiter = new Recruiter(
            dto.id,
            dto.name,
            dto.email,
            dto.phone,
            dto.companyName,
            dto.companyDescription,
            dto.companyWebsite
        );

        recruiter = recruiterRepository.save(recruiter);

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

    public RecruiterDTO getRecruiterByEmail(String email) {
        Recruiter recruiter = recruiterRepository.findByEmail(email);
        if (recruiter == null) return null;

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

    public RecruiterDTO getRecruiterById(Long id) {
        Optional<Recruiter> optionalRecruiter = recruiterRepository.findById(id);
        if (!optionalRecruiter.isPresent()) return null;

        Recruiter recruiter = optionalRecruiter.get();

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
}
