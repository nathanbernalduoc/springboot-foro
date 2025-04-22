package com.nathan.springboot_foro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.springboot_foro.dto.ComentarioDto;
import com.nathan.springboot_foro.repository.ComentarioRepository;

@Service
public class ComentarioServicelmpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Override
    public List<ComentarioDto> getAllComentario() {
        return comentarioRepository.findAll();
    }

    @Override
    public Optional<ComentarioDto> getComentarioById(Long id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public ComentarioDto createComentario(ComentarioDto comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public ComentarioDto updateComentario(Long id, ComentarioDto comentario) {
        if (comentarioRepository.existsById(id)) {
            comentario.setComentarioId(id);
            return comentarioRepository.save(comentario);
        } else {
            return null;
        }
    }

    @Override
    public void deleteComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
