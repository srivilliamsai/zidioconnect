package com.zidio.zidioconnect.service;

import java.util.List;
import com.zidio.zidioconnect.dto.RecruiterDTO;

public interface RecruiterService {

    RecruiterDTO createRecruiter(RecruiterDTO recruiterDTO);

    RecruiterDTO getRecruiterById(Long id);

    List<RecruiterDTO> getAllRecruiters();

    RecruiterDTO updateRecruiter(Long id, RecruiterDTO recruiterDTO);

    void deleteRecruiter(Long id);

    RecruiterDTO searchByEmail(String email);

    List<RecruiterDTO> searchByCompanyName(String companyName);
}