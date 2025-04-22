package com.nathan.springboot_foro.service;

import java.util.List;
import java.util.Optional;

import com.nathan.springboot_foro.dto.ForoDto;

public interface ForoService {

    List<ForoDto> getAllForo();
    Optional<ForoDto> getForoById(Long id);
    
    ForoDto createForo(ForoDto usuario);
    ForoDto updateForo(Long id, ForoDto usuario);
    void deleteForo(Long id);


}
