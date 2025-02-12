package br.com.arquitec.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_general_info")
public class GeneralInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_general_info")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "reuse_general_info")
    private String reuse;

    @Column(name = "additional_general_info")
    private String additionalInfo;

    @Column(name = "unlisted_furniture_or_equipment_general_info")
    private String unlistedFurnitureOrEquipment;

    @Column(name = "avoidance_requests_general_info")
    private String avoidanceRequests;

    @Column(name = "plant_relationship_general_info")
    private String plantRelationship;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}