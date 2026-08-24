package com.ramos.heldesk_backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hiloTicket")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hilo")
    private Long idComment;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "nota_interna", nullable = false)
    private Boolean internalNote = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ticket", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user",  nullable = false)
    private User user;

    @OneToMany(mappedBy = "comentario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attachment> attachments = new ArrayList<>();

    @Column(name = "creado", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "actualizado")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        if (this.internalNote == null){
            this.internalNote = true;
        }
    }

    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
