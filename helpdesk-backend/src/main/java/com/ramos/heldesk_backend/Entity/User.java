package com.ramos.heldesk_backend.Entity;

import com.ramos.heldesk_backend.Enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "nombre", nullable = false)
    @Size(min = 3, max = 15)
    private String nombre;

    @NotNull
    private String paterno;

    private String materno;

    @Size(min = 3, max = 15)
    private String usuario;

    @Email
    @NotNull
    private String email;

    @Min(8)
    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    //Relacion de muchos usuarios a un departamento
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento", nullable = true)
    private Department departamento;
}
