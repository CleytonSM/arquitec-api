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
@Table(name = "tb_living_room")
public class LivingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_living_room")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "people_in_living_room")
    private Integer peopleInLivingRoom;

    @Column(name = "bool_tv_is_important_living_room")
    private Boolean tvIsImportant;

    @Column(name = "tv_inch_living_room")
    private Integer tvInch;

    @Column(name = "equipment_living_room")
    private String equipment;

    @Column(name = "bool_sofa_with_chaise_living_room")
    private Boolean sofaWithChaise;

    @Column(name = "bool_sofa_with_retractable_chaise_living_room")
    private Boolean sofaWithRetractableChaise;

    @Column(name = "bool_books_or_collection_living_room")
    private Boolean booksOrCollection;

    @Column(name = "bool_used_daily_living_room")
    private Boolean usedDaily;

    @Column(name = "receives_many_people_living_room")
    private String receivesManyPeople;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}