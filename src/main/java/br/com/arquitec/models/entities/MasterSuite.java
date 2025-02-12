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
@Table(name = "tb_master_suite")
public class MasterSuite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_master_suite")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "bed_type_suite")
    private String bedType;

    @Column(name = "bool_tv_in_master_suite")
    private Boolean tvInMasterSuite;

    @Column(name = "bool_armchair_master_suite")
    private Boolean armchair;

    @Column(name = "bool_bench_master_suite")
    private Boolean bench;

    @Column(name = "bool_reads_in_bed_master_suite")
    private Boolean readsInBed;

    @Column(name = "bool_nightstand_drawer_master_suite")
    private Boolean nightstandDrawer;

    @Column(name = "bool_wood_headboard_preference_master_suite")
    private Boolean woodHeadboardPreference;

    @Column(name = "bool_fabric_headboard_preference_master_suite")
    private Boolean fabricHeadboardPreference;

    @Column(name = "bool_full_length_mirror_in_master_suite")
    private Boolean fullLengthMirror;

    @Column(name = "current_closet_length_master_suite")
    private BigDecimal currentClosetLength;

    @Column(name = "current_clothes_rail_length_master_suite")
    private BigDecimal currentClothesRailLength;

    @Column(name = "current_shoe_pairs_count_master_suite")
    private Integer currentShoePairsCount;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}