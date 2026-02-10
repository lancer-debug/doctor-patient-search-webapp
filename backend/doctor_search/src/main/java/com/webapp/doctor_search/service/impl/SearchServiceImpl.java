package com.webapp.doctor_search.service.impl;

import com.webapp.doctor_search.entity.Specialization;
import com.webapp.doctor_search.entity.dto.SpecializationResponseDTO;
import com.webapp.doctor_search.entity.mapper.SpecializationMapper;
import com.webapp.doctor_search.repository.SpecializationRepository;
import com.webapp.doctor_search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private SpecializationRepository specializationRepository;
    private SpecializationMapper specializationMapper;

    @Override
    public List<SpecializationResponseDTO> getSpecializations() {
        return specializationMapper.toResponseDTOList(
                specializationRepository.findAll()
        );
    }

    public SpecializationResponseDTO getSpecialization(UUID id) {
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization Not Found"));

        return specializationMapper.toResponseDTO(specialization);
    }
}
