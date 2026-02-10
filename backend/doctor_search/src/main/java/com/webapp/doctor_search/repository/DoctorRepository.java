package com.webapp.doctor_search.repository;

import com.webapp.doctor_search.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Boolean existsByEmail(String email);
}
