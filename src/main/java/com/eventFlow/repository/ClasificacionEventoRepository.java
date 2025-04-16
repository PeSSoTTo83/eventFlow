package com.eventFlow.repository;

import com.eventFlow.model.ClasificacionEvento;
import com.eventFlow.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasificacionEventoRepository extends JpaRepository<ClasificacionEvento, Long> {
    ClasificacionEvento findByEvento(Evento evento);
}
