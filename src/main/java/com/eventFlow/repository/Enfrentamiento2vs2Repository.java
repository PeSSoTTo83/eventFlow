package com.eventFlow.repository;

import com.eventFlow.model.EnfrentamientoParticipante2vs2;
import com.eventFlow.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Enfrentamiento2vs2Repository extends JpaRepository<EnfrentamientoParticipante2vs2, Long> {
    List<EnfrentamientoParticipante2vs2> findByEvento(Evento evento);
}
