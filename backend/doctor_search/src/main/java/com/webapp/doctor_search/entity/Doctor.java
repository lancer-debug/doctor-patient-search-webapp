    package com.webapp.doctor_search.entity;

    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import jakarta.persistence.*;
    import lombok.*;


    import java.time.LocalDateTime;
    import java.util.HashSet;
    import java.util.Set;
    import java.util.UUID;

    @Entity
    @Table(name = "doctors")
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public class Doctor {

        @Id
        @GeneratedValue(generator = "UUID")
        @Column(name = "id", updatable = false, nullable = false)
        private UUID id;

        @Column(name = "name", nullable = false, length = 255)
        private String name;

        @Column(name = "email", nullable = false, unique = true, length = 255)
        private String email;

        @Column(name = "password", nullable = false, length = 255)
        private String password; // Store hashed password only

        @Column(name = "mobile_no", length = 20)
        private String mobileNo;

        @Column(name = "license_no", length = 100)
        private String licenseNo;

        @Column(name = "verified", nullable = false)
        private Boolean verified = false;

        // Many-to-One with Location
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
        @JoinColumn(name = "location_id", referencedColumnName = "id")
        private Location location;

        // Many-to-Many with Specialization (using junction table)
        @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(
                name = "doctor_specialization",
                joinColumns = @JoinColumn(name = "doctor_id"),
                inverseJoinColumns = @JoinColumn(name = "specialization_id")
        )
        private Set<Specialization> specializations = new HashSet<>();

        // One-to-Many with Education
        @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonManagedReference
        private Set<Education> educations = new HashSet<>();

        // One-to-Many with Experience
        @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonManagedReference
        private Set<Experience> experiences = new HashSet<>();

        @Column(name = "experience_years", nullable = false)
        private Integer experienceYears;

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