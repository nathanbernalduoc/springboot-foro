package com.nathan.springboot_foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathan.springboot_foro.dto.ForoDto;

public interface ForoRepository extends JpaRepository<ForoDto, Long> {

}
