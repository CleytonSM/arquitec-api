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
@Table(name = "tb_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "nickname_customer")
    private String nickname;

    @Column(name = "birthday_customer", nullable = false)
    private LocalDateTime birthday;

    @Column(name = "marital_status_customer", nullable = false)
    private String maritalStatus;

    @Column(name = "religion_customer")
    private String religion;

    @Column(name = "veg_vege_customer")
    private Boolean vegVege;

    @Column(name = "individual_needs_customer")
    private String individualNeeds;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}