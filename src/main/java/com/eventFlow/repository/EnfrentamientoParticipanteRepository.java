package com.eventFlow.repository;

import com.eventFlow.model.EnfrentamientoParticipante;
import com.eventFlow.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnfrentamientoParticipanteRepository extends JpaRepository<EnfrentamientoParticipante, Long> {
    List<EnfrentamientoParticipante> findByEvento(Evento evento);
}
