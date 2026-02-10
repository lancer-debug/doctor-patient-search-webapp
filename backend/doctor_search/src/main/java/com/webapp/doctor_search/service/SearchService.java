package com.webapp.doctor_search.service;

import com.webapp.doctor_search.entity.dto.SpecializationResponseDTO;

import java.util.List;
import java.util.UUID;

public interface SearchService {
    List<SpecializationResponseDTO> getSpecializations();
    SpecializationResponseDTO getSpecialization(UUID id);
}
