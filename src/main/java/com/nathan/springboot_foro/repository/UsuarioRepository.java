package com.nathan.springboot_foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.springboot_foro.dto.UsuarioDto;

public interface UsuarioRepository extends JpaRepository<UsuarioDto, Long> {
    
}
