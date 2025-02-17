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
@Table(name = "tb_description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desc")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "best_place_desc")
    private String bestPlace;

    @Column(name = "wknd_best_place_desc")
    private String wkndBestPlace;

    @Column(name = "miss_actual_house_desc")
    private String missActualHouse;

    @Column(name = "bool_actual_house_satisfaction")
    private Boolean actualHouseSatisfaction;

    @Column(name = "actual_house_satisfaction_desc")
    private String actualHouseSatisfactionDesc;

    @Column(name = "job_desc")
    private String job;

    @Column(name = "work_routine_desc")
    private String workRoutine;

    @Column(name = "bool_work_at_home")
    private Boolean workAtHome;

    @Column(name = "days_working_at_home")
    private Integer daysWorkingAtHome;

    @Column(name = "bool_travels_for_work")
    private Boolean travelsForWork;

    @Column(name = "travels_for_work_desc")
    private String travelsForWorkDesc;

    @Column(name = "bool_pratice_sports")
    private Boolean practiceSports;

    @Column(name = "practice_sports_desc")
    private String practiceSportsDesc;

    @Column(name = "bool_travel")
    private Boolean travel;

    @Column(name = "travel_desc")
    private String travelDesc;

    @Column(name = "bool_watch_tv")
    private Boolean watchTv;

    @Column(name = "watch_tv_desc")
    private String watchTvDesc;

    @Column(name = "bool_read")
    private Boolean read;

    @Column(name = "bool_book_read")
    private Boolean bookRead;

    @Column(name = "bool_tablet_read")
    private Boolean tabletRead;

    @Column(name = "bool_pets")
    private Boolean pets;

    @Column(name = "pets_desc")
    private String petsDesc;

    @Column(name = "bool_cook")
    private Boolean cook;

    @Column(name = "cook_desc")
    private String cookDesc;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}