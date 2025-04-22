package com.nathan.springboot_foro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathan.springboot_foro.dto.ForoDto;
import com.nathan.springboot_foro.repository.ForoRepository;

@Service
public class ForoServicelmpl implements ForoService {

    @Autowired
    private ForoRepository foroRepository;
    
    @Override
    public List<ForoDto> getAllForo() {
        return foroRepository.findAll();
    }

    @Override
    public Optional<ForoDto> getForoById(Long id) {
        return foroRepository.findById(id);
    }

    @Override
    public ForoDto createForo(ForoDto foro) {
        return foroRepository.save(foro);
    }

    @Override
    public ForoDto updateForo(Long id, ForoDto foro) {
        if (foroRepository.existsById(id)) {
            foro.setForoId(id);
            return foroRepository.save(foro);
        } else {
            return null;
        }
    }

    @Override
    public void deleteForo(Long id) {
        foroRepository.deleteById(id);
    }
}
