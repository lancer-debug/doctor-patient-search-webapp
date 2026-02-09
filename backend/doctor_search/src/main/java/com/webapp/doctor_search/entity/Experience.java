package com.webapp.doctor_search.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "experiences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    // Many-to-One with Doctor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false, referencedColumnName = "id")
    private Doctor doctor;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "hospital_name", nullable = false, length = 255)
    private String hospitalName;

    @Column(name = "employment_type", length = 100)
    private String employmentType; // e.g., Full-time, Part-time, Contract, etc.

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate; // Nullable for current positions

    @Column(name = "currently_working", nullable = false)
    private Boolean currentlyWorking = false;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
