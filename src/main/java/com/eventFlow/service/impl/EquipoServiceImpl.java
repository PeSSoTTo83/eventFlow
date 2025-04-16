package com.eventFlow.service.impl;

import com.eventFlow.model.Equipo;
import com.eventFlow.model.Evento;
import com.eventFlow.repository.EquipoRepository;
import com.eventFlow.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository repo;

    @Override
    public List<Equipo> listarPorEvento(Evento evento) {
        return repo.findByEvento(evento);
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        return repo.save(equipo);
    }

    @Override
    public Equipo buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
}
