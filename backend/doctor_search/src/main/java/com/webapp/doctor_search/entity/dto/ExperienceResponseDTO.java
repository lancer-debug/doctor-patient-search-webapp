package com.webapp.doctor_search.entity.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ExperienceResponseDTO(
        UUID id, String title, String hospitalName,
        String employmentType, LocalDate startEnd, LocalDate endDate, Boolean currentlyWorking) {
}
