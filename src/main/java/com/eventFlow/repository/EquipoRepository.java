package com.eventFlow.repository;

import com.eventFlow.model.Equipo;
import com.eventFlow.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findByEvento(Evento evento);
}
