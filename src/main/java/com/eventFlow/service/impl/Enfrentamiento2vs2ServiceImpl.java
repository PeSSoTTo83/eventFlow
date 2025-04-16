package com.eventFlow.service.impl;

import com.eventFlow.model.EnfrentamientoParticipante2vs2;
import com.eventFlow.model.Evento;
import com.eventFlow.repository.Enfrentamiento2vs2Repository;
import com.eventFlow.service.Enfrentamiento2vs2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Enfrentamiento2vs2ServiceImpl implements Enfrentamiento2vs2Service {

    @Autowired
    private Enfrentamiento2vs2Repository repo;

    @Override
    public void guardar(EnfrentamientoParticipante2vs2 enfrentamiento) {
        repo.save(enfrentamiento);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public EnfrentamientoParticipante2vs2 buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EnfrentamientoParticipante2vs2> listarPorEvento(Evento evento) {
        return repo.findByEvento(evento);
    }
}
