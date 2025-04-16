package com.eventFlow.service.impl;

import com.eventFlow.model.EnfrentamientoParticipante1vs1;
import com.eventFlow.model.Evento;
import com.eventFlow.repository.Enfrentamiento1vs1Repository;
import com.eventFlow.service.Enfrentamiento1vs1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Enfrentamiento1vs1ServiceImpl implements Enfrentamiento1vs1Service {

    @Autowired
    private Enfrentamiento1vs1Repository repo;

    @Override
    public void guardar(EnfrentamientoParticipante1vs1 enfrentamiento) {
        repo.save(enfrentamiento);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public EnfrentamientoParticipante1vs1 buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EnfrentamientoParticipante1vs1> listarPorEvento(Evento evento) {
        return repo.findByEvento(evento);
    }
}
