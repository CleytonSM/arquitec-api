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
@Table(name = "tb_necessary_appliances_in_kitchen")
public class NecessaryAppliancesInKitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_necessary_appliances_in_kitchen")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_kitchen")
    private Kitchen kitchen;

    @Column(name = "bool_store_small_visible_appliances")
    private Boolean storeSmallVisibleAppliances;

    @Column(name = "bool_store_small_hidden_appliances")
    private Boolean storeSmallHiddenAppliances;

    @Column(name = "name_necessary_appliances_in_kitchen")
    private String name;

    @Column(name = "bool_used_daily_necessary_appliances_in_kitchen")
    private Boolean usedDaily;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}