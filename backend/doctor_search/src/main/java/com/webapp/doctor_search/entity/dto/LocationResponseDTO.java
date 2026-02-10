package com.webapp.doctor_search.entity.dto;

import java.util.UUID;

public record LocationResponseDTO(
        UUID id, String address, String city,
        String state, String pinCode, String country) {
}
