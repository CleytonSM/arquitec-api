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
@Table(name = "tb_kitchen")
public class Kitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kitchen")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "color_type_kitchen")
    private String colorType;

    @Column(name = "shape_type_kitchen")
    private String shapeType;

    @Column(name = "counter_top_material_kitchen")
    private String counterTopMaterial;

    @Column(name = "material_preference_kitchen")
    private String materialPreference;

    @Column(name = "bool_wet_gutter_or_built_in_trash_can_kitchen")
    private Boolean wetGutterOrBuiltInTrashCan;

    @Column(name = "bool_stove_kitchen")
    private Boolean stove;

    @Column(name = "bool_cooktop_kitchen")
    private Boolean cooktop;

    @Column(name = "bool_induction_kitchen")
    private Boolean induction;

    @Column(name = "bool_burners_kitchen")
    private Boolean burners;

    @Column(name = "bool_stove_on_counter_top_kitchen")
    private Boolean stoveOnCounterTop;

    @Column(name = "bool_stove_on_tower_kitchen")
    private Boolean stoveOnTower;

    @Column(name = "fridge_type_kitchen")
    private String fridgeType;

    @Column(name = "bool_separate_freezer_kitchen")
    private Boolean separateFreezer;

    @Column(name = "fridge_capacity_liters_kitchen")
    private Integer fridgeCapacityLiters;

    @Column(name = "current_storage_satisfaction_kitchen")
    private String currentStorageSatisfaction;

    @Column(name = "dinner_capacity_kitchen")
    private Integer dinnerCapacity;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}