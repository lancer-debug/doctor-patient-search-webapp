package com.webapp.doctor_search.controller;

import com.webapp.doctor_search.entity.dto.SpecializationResponseDTO;
import com.webapp.doctor_search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SearchController {
    private SearchService searchService;

    @GetMapping("/specializations")
    public ResponseEntity<List<SpecializationResponseDTO>> getSpecializations() {
        return ResponseEntity.ok(searchService.getSpecializations());
    }

    @GetMapping("/specializations/{id}")
    public ResponseEntity<SpecializationResponseDTO> getSpecialization(
            @PathVariable UUID id) {
        return ResponseEntity.ok(searchService.getSpecialization(id));
    }

}
