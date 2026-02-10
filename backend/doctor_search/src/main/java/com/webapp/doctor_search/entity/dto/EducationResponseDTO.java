package com.webapp.doctor_search.entity.dto;

import java.time.LocalDate;
import java.util.UUID;

public record EducationResponseDTO(
        UUID id, String schoolName, String degree,
        String fieldOfStudy, LocalDate startDate, LocalDate endDate) {
}
