package com.webapp.doctor_search.service;

import com.webapp.doctor_search.entity.dto.DoctorRequestDTO;

public interface RegisterService {
    String register(DoctorRequestDTO requestDTO);
}
