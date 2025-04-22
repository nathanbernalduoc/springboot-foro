package com.nathan.springboot_foro.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "NF_FORO")

public class ForoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foro_secuence")
    @SequenceGenerator(name = "foro_secuence", sequenceName = "SEQ_NF_FORO_ID", allocationSize = 1)
    @Column(name = "FORO_ID")
    private Long foroId;
    @Column(name = "NOMBRE")
    private String nombre;

    ForoDto() {

    }

    ForoDto(Long foroId, String nombre) {
        this.foroId = foroId;
        this.nombre = nombre;
    }

    public Long getForoId() {
        return foroId;
    }

    public void setForoId(Long foroId) {
        this.foroId = foroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
