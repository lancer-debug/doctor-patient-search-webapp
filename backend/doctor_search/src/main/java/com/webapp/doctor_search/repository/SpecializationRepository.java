package com.webapp.doctor_search.repository;

import com.webapp.doctor_search.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecializationRepository extends JpaRepository<Specialization, UUID> {
}
