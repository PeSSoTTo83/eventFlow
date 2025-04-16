package com.eventFlow.service.impl;

import com.eventFlow.model.Evento;
import com.eventFlow.repository.EventoRepository;
import com.eventFlow.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository repo;

    @Override
    public List<Evento> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Evento buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Evento guardar(Evento evento) {
        return repo.save(evento);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
