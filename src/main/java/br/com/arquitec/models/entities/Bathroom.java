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
@Table(name = "tb_bathroom")
public class Bathroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bathroom")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "bool_all_renovated_bathroom")
    private Boolean allRenovated;

    @Column(name = "preferred_sink_shape_bathroom")
    private String preferredSinkShape;

    @Column(name = "preferred_flush_type_bathroom")
    private String preferredFlushType;

    @Column(name = "bool_hygienic_shower_bathroom")
    private Boolean hygienicShower;

    @Column(name = "bool_bidet_bathroom")
    private Boolean bidet;

    @Column(name = "bool_prefers_mixer_tap_bathroom")
    private Boolean prefersMixerTap;

    @Column(name = "bool_prefers_single_handle_bathroom")
    private Boolean prefersSingleHandle;

    @Column(name = "bool_electric_towel_rack_bathroom")
    private Boolean electricTowelRack;

    @Column(name = "bool_laundry_hamper_in_cabinet_bathroom")
    private Boolean laundryHamperInCabinet;

    @Column(name = "bool_makeup_in_bathroom_mirror_bathroom")
    private Boolean makeupInBathroomMirror;

    @Column(name = "bool_many_products_on_counter_bathroom")
    private Boolean manyProductsOnCounter;

    @Column(name = "bool_daily_use_of_hairdryer_bathroom")
    private Boolean dailyUseOfHairdryer;

    @Column(name = "bool_shower_niche_for_products_bathroom")
    private Boolean showerNicheForProducts;

    @Column(name = "bool_current_storage_meets_needs_bathroom")
    private Boolean currentStorageMeetsNeeds;

    @Column(name = "bool_desire_more_storage_space_bathroom")
    private Boolean desireMoreStorageSpace;

    @Column(name = "bool_sauna_in_shower_bathroom")
    private Boolean saunaInShower;

    @Column(name = "bool_bathtub_bathroom")
    private Boolean bathtub;

    @Column(name = "bool_immersion_bathroom")
    private Boolean immersion;

    @Column(name = "bool_hydro_bathroom")
    private Boolean hydro;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}