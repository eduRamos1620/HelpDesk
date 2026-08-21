package com.ramos.heldesk_backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "categoria")
    @NotNull
    private String nombreCategoria;

    @NotNull
    @Column(name = "estatus", nullable = false)
    private Boolean activo = true;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parent")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private List<Category> subCategories;
}
