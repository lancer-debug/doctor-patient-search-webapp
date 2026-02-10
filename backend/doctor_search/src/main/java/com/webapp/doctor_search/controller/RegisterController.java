package com.webapp.doctor_search.controller;

import com.webapp.doctor_search.entity.dto.DoctorRequestDTO;
import com.webapp.doctor_search.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody DoctorRequestDTO requestDTO) {

        return ResponseEntity.ok(registerService.register(requestDTO));
    }
}
