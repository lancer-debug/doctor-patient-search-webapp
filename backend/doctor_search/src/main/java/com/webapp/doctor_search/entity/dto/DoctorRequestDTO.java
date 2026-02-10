package com.webapp.doctor_search.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDTO {
    private String name;
    private String email;
    private String password;
    private String mobileNo;
    private String licenseNo;
    private LocationRequestDTO location;
    private List<SpecializationRequestDTO> specializations;
    private List<EducationRequestDTO> educations;
    private List<ExperienceRequestDTO> experiences;
    private Integer experienceYears;
}
