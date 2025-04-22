package com.nathan.springboot_foro.service;

import java.util.List;
import java.util.Optional;

import com.nathan.springboot_foro.dto.UsuarioDto;

public interface  UsuarioService {

    List<UsuarioDto> getAllUsuarios();
    Optional<UsuarioDto> getUsuarioById(Long id);
    Optional<UsuarioDto> getUsuarioByAlias(String alias);
    
    UsuarioDto createUsuario(UsuarioDto usuario);
    UsuarioDto updateUsuario(Long id, UsuarioDto usuario);
    void deleteUsuario(Long id);

}
