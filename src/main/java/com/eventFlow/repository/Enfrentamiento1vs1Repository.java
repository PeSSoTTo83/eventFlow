package com.eventFlow.repository;

import com.eventFlow.model.EnfrentamientoParticipante1vs1;
import com.eventFlow.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Enfrentamiento1vs1Repository extends JpaRepository<EnfrentamientoParticipante1vs1, Long> {
    List<EnfrentamientoParticipante1vs1> findByEvento(Evento evento);
}
