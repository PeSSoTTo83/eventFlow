package com.eventFlow.service;

import com.eventFlow.model.EnfrentamientoParticipante1vs1;
import com.eventFlow.model.Evento;

import java.util.List;

public interface Enfrentamiento1vs1Service {
    void guardar(EnfrentamientoParticipante1vs1 enfrentamiento);
    void eliminar(Long id);
    EnfrentamientoParticipante1vs1 buscarPorId(Long id);
    List<EnfrentamientoParticipante1vs1> listarPorEvento(Evento evento);
}
