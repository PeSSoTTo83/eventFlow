package com.eventFlow.service.impl;

import com.eventFlow.model.ClasificacionVersus;
import com.eventFlow.model.Evento;
import com.eventFlow.repository.ClasificacionVersusRepository;
import com.eventFlow.service.ClasificacionVersusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasificacionVersusServiceImpl implements ClasificacionVersusService {

    @Autowired
    private ClasificacionVersusRepository repo;

    @Override
    public List<ClasificacionVersus> listarPorEvento(Evento evento) {
        return repo.findByEvento(evento);
    }

    @Override
    public ClasificacionVersus guardar(ClasificacionVersus cv) {
        return repo.save(cv);
    }
}
