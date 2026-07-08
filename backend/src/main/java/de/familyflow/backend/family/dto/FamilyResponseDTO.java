package de.familyflow.backend.family.dto;

import java.time.LocalDateTime;

public class FamilyResponseDTO {

    private Long id;
    private String familyName;
    private LocalDateTime createdAt;


    public FamilyResponseDTO(
            Long id,
            String familyName,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.familyName = familyName;
        this.createdAt = createdAt;
    }


    public Long getId() {
        return id;
    }


    public String getFamilyName() {
        return familyName;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}