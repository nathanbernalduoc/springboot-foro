package com.nathan.springboot_foro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.springboot_foro.dto.UsuarioDto;
import com.nathan.springboot_foro.repository.UsuarioRepository;

@Service
public class UsuarioServicelmpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public List<UsuarioDto> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioDto> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Boolean login(String alias, String pass) {
        UsuarioDto usuario = usuarioRepository.findByAlias(alias);
        return (usuario != null && usuario.getPassword().equals(pass));
    }

    @Override
    public Optional<UsuarioDto> getUsuarioByAlias(String alias) {
        return Optional.of(usuarioRepository.findByAlias(alias));
    }

    @Override
    public UsuarioDto createUsuario(UsuarioDto usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDto updateUsuario(Long id, UsuarioDto usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
