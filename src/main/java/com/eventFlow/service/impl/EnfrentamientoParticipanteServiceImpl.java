package com.eventFlow.service.impl;

import com.eventFlow.model.EnfrentamientoParticipante;
import com.eventFlow.model.Evento;
import com.eventFlow.repository.EnfrentamientoParticipanteRepository;
import com.eventFlow.service.EnfrentamientoParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfrentamientoParticipanteServiceImpl implements EnfrentamientoParticipanteService {

    @Autowired
    private EnfrentamientoParticipanteRepository repo;

    @Override
    public List<EnfrentamientoParticipante> listarPorEvento(Evento evento) {
        return repo.findByEvento(evento);
    }

    @Override
    public void guardar(EnfrentamientoParticipante enfrentamiento) {
        repo.save(enfrentamiento);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public EnfrentamientoParticipante buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
}
