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
@Table(name = "tb_experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experience")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "neutral_color_exp")
    private String neutralColor;

    @Column(name = "lively_color_exp")
    private String livelyColor;

    @Column(name = "like_to_feel_exp")
    private String likeToFeel;

    @Column(name = "house_meaning_exp")
    private String houseMeaning;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}