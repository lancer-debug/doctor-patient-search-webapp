package com.webapp.doctor_search.entity.mapper;

import com.webapp.doctor_search.entity.Specialization;
import com.webapp.doctor_search.entity.dto.SpecializationResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {
    SpecializationResponseDTO toResponseDTO(Specialization specialization);

    List<SpecializationResponseDTO> toResponseDTOList(List<Specialization> specializations);
}
