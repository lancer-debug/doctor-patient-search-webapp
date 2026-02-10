package com.webapp.doctor_search.service.impl;

import com.webapp.doctor_search.entity.*;
import com.webapp.doctor_search.entity.dto.DoctorRequestDTO;
import com.webapp.doctor_search.repository.DoctorRepository;
import com.webapp.doctor_search.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final DoctorRepository doctorRepository;

    @Override
    public String register(DoctorRequestDTO requestDTO) {

        if(doctorRepository.existsByEmail(requestDTO.getEmail())) {
            return "Email already exists";
        }

        Location location = Location.builder()
                .address(requestDTO.getLocation().getAddress())
                .city(requestDTO.getLocation().getCity())
                .state(requestDTO.getLocation().getState())
                .pinCode(requestDTO.getLocation().getPinCode())
                .country(requestDTO.getLocation().getCountry())
                .build();

        Set<Specialization> specializationSet =
                requestDTO.getSpecializations().stream()
                        .map(specializationRequestDTO -> {
                            return Specialization.builder()
                                    .name(specializationRequestDTO.getName())
                                    .description(specializationRequestDTO.getDescription())
                                    .build();
                        })
                        .collect(Collectors.toSet());

        Doctor doctor = Doctor.builder()
                .name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .password(requestDTO.getPassword())
                .mobileNo(requestDTO.getMobileNo())
                .licenseNo(requestDTO.getLicenseNo())
                .experienceYears(requestDTO.getExperienceYears())
                .verified(false)
                .location(location)
                .specializations(specializationSet)
                .build();


        Set<Education> educationSet =
                requestDTO.getEducations().stream()
                        .map(educationRequestDTO -> {
                            Education education = Education.builder()
                                    .schoolName(educationRequestDTO.getSchoolName())
                                    .degree(educationRequestDTO.getDegree())
                                    .fieldOfStudy(educationRequestDTO.getFieldOfStudy())
                                    .startDate(educationRequestDTO.getStartDate())
                                    .endDate(educationRequestDTO.getEndDate())
                                    .grade(educationRequestDTO.getGrade())
                                    .description(educationRequestDTO.getDescription())
                                    .build();
                            education.setDoctor(doctor);
                            return education;
                        })
                        .collect(Collectors.toSet());

        Set<Experience> experienceSet =
                requestDTO.getExperiences().stream()
                        .map(experienceRequestDTO -> {
                            Experience experience = Experience.builder()
                                    .title(experienceRequestDTO.getTitle())
                                    .hospitalName(experienceRequestDTO.getHospitalName())
                                    .employmentType(experienceRequestDTO.getEmploymentType())
                                    .startDate(experienceRequestDTO.getStartDate())
                                    .endDate(experienceRequestDTO.getEndDate())
                                    .currentlyWorking(experienceRequestDTO.getCurrentlyWorking())
                                    .description(experienceRequestDTO.getDescription())
                                    .build();
                            experience.setDoctor(doctor);
                            return experience;
                        })
                        .collect(Collectors.toSet());


        doctor.setEducations(educationSet);
        doctor.setExperiences(experienceSet);
        doctorRepository.save(doctor);

        return "Profile Created Successfully";

    }
}
