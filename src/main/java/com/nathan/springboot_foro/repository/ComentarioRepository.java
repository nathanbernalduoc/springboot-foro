package com.nathan.springboot_foro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.springboot_foro.dto.ComentarioDto;

public interface ComentarioRepository extends JpaRepository<ComentarioDto, Long> {

    public List<ComentarioDto> findByForoId(Long foroId);

}
