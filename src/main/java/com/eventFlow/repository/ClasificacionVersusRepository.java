package com.eventFlow.repository;

import com.eventFlow.model.ClasificacionVersus;
import com.eventFlow.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasificacionVersusRepository extends JpaRepository<ClasificacionVersus, Long> {
    List<ClasificacionVersus> findByEvento(Evento evento);
}
