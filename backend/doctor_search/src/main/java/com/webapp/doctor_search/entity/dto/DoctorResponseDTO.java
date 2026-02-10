package com.webapp.doctor_search.entity.dto;

import java.util.UUID;

public record DoctorResponseDTO(
        UUID id, String name, String email, String mobileNo,
        String licenseNo, LocationResponseDTO location, SpecializationResponseDTO specialization,
        EducationResponseDTO educations, ExperienceResponseDTO experiences, Integer experienceYears) {
}
