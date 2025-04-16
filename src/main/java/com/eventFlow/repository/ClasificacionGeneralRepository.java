package com.eventFlow.repository;

import com.eventFlow.model.ClasificacionGeneral;
import com.eventFlow.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasificacionGeneralRepository extends JpaRepository<ClasificacionGeneral, Long> {
    List<ClasificacionGeneral> findByEvento(Evento evento);
}
