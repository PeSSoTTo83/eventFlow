package com.eventFlow.service.impl;

import com.eventFlow.model.Participante;
import com.eventFlow.model.Evento;
import com.eventFlow.repository.ParticipanteRepository;
import com.eventFlow.repository.EventoRepository;
import com.eventFlow.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository repo;

    @Autowired
    private EventoRepository eventoRepo;

    @Override
    public List<Participante> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Participante buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Participante guardar(Participante participante) {
        boolean esNuevo = (participante.getIdParticipante() == null);

        Participante saved = repo.save(participante);

        // ✅ Incrementar el contador solo si es nuevo
        if (esNuevo) {
            Evento evento = saved.getEvento();
            if (evento != null) {
                evento.setNumParticipantes(evento.getNumParticipantes() + 1);
                eventoRepo.save(evento);
            }
        }

        return saved;
    }

    @Override
    public void eliminar(Long id) {
        Participante participante = repo.findById(id).orElse(null);
        if (participante != null) {
            Evento evento = participante.getEvento();
            if (evento != null && evento.getNumParticipantes() > 0) {
                evento.setNumParticipantes(evento.getNumParticipantes() - 1);
                eventoRepo.save(evento);
            }
            repo.delete(participante);
        }
    }

    // ✅ NUEVO MÉTODO AÑADIDO
    @Override
    public List<Participante> listarPorEvento(Evento evento) {
        return repo.findByEvento(evento);
    }
}
