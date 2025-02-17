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
@Table(name = "tb_entrance_hall")
public class EntranceHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrance_hall")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "bool_shoes_house_walking_entrance_hall")
    private Boolean shoesHouseWalking;

    @Column(name = "bool_has_entrance_console_table_entrance_hall")
    private Boolean hasEntranceConsoleTable;

    @Column(name = "bool_want_entrance_console_table_entrance_hall")
    private Boolean wantEntranceConsoleTable;

    @Column(name = "bool_full_length_mirror_entrance_hall")
    private Boolean fullLengthMirror;

    @Column(name = "bool_familiar_with_electronic_locks_entrance_hall")
    private Boolean familiarWithElectronicLocks;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}