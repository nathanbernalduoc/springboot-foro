package com.nathan.springboot_foro.service;

import java.util.List;
import java.util.Optional;

import com.nathan.springboot_foro.dto.ComentarioDto;

public interface ComentarioService {

    List<ComentarioDto> getAllComentario();
    Optional<ComentarioDto> getComentarioById(Long id);
    
    ComentarioDto createComentario(ComentarioDto usuario);
    ComentarioDto updateComentario(Long id, ComentarioDto usuario);
    void deleteComentario(Long id);


}
