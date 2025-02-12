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
@Table(name = "tb_descendants_suite")
public class DescendantsSuite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descendants_suite")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_form", nullable = false)
    private Form form;

    @Column(name = "bed_type_suite")
    private String bedType;

    @Column(name = "bool_tv_in_descendants_suite")
    private Boolean tvInDescendantsSuite;

    @Column(name = "bool_child_study_in_descendants_suite")
    private Boolean childStudy;

    @Column(name = "bool_child_receives_friends_to_sleep_descendants_suite")
    private Boolean childReceivesFriendsToSleep;

    @Column(name = "theme_descendants_suite")
    private String theme;

    @Column(name = "is_filled")
    private Boolean isFilled;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}