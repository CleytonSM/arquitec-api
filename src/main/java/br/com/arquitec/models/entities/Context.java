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
@Table(name = "tb_context")
public class Context {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_context")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "project_life_stage_significance_context")
    private String projectLifeStageSignificance;

    @Column(name = "investment_expectation_context")
    private String investmentExpectation;

    @Column(name = "project_duration_expectation_context")
    private String projectDurationExpectation;

    @Column(name = "location_during_renovation_context")
    private String locationDuringRenovation;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}