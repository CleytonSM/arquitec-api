package br.com.arquitec.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_auth")
    private Authority authority;

    @Column(name = "name_user")
    private String name;

    @Column(name = "lastname_user")
    private String lastname;
    @Column(name = "email_user")
    private String email;

    @Column(name = "pwd_user")
    private String password;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "is_fully_created")
    private Boolean isFullyCreated;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @Column(name = "deleted_at")
    private LocalDateTime deleteAt;
}
