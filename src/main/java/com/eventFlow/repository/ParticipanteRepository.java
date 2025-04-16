package com.eventFlow.repository;

import com.eventFlow.model.Evento;
import com.eventFlow.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    List<Participante> findByEvento(Evento evento);
}
