package br.com.arquitec.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_laundry")
public class Laundry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laundry")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "bool_built_in_sink_laundry")
    private Boolean builtInSink;

    @Column(name = "bool_porcelain_sink_laundry")
    private Boolean porcelainSink;

    @Column(name = "bool_pet_food_and_bowls_stored_here_laundry")
    private Boolean petFoodAndBowlsStoredHere;

    @Column(name = "bool_recycles_trash_laundry")
    private Boolean recyclesTrash;

    @Column(name = "current_drying_rack_count_laundry")
    private Integer currentDryingRackCount;

    @Column(name = "drying_rack_sizes_laundry")
    private BigDecimal dryingRackSizes;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}