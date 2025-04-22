package com.nathan.springboot_foro.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "NF_COMENTARIO")

public class ComentarioDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_secuence")
    @SequenceGenerator(name = "comentario_secuence", sequenceName = "SEQ_NF_COMENTARIO_ID", allocationSize = 1)
    @Column(name = "COMENTARIO_ID")
    private Long comentarioId;
    @Column(name = "COMENTARIO")
    private String comentario;
    @Column(name = "USUARIO")
    private String usuario;

    ComentarioDto() {

    }

    ComentarioDto(Long comentarioId, String comentario, String usuario) {
        this.comentarioId = comentarioId;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public Long getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuariu() {
        return usuario;
    }

    public void setUsuariu(String usuario) {
        this.usuario = usuario;
    }


    
}
