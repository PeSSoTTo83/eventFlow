package com.eventFlow.service.impl;

import com.eventFlow.model.Patrocinador;
import com.eventFlow.repository.PatrocinadorRepository;
import com.eventFlow.service.PatrocinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrocinadorServiceImpl implements PatrocinadorService {

    @Autowired
    private PatrocinadorRepository repo;

    @Override
    public List<Patrocinador> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Patrocinador buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Patrocinador guardar(Patrocinador patrocinador) {
        return repo.save(patrocinador);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
