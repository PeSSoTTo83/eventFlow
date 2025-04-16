package com.eventFlow.service;

import com.eventFlow.model.EnfrentamientoParticipante2vs2;
import com.eventFlow.model.Evento;

import java.util.List;

public interface Enfrentamiento2vs2Service {
    void guardar(EnfrentamientoParticipante2vs2 enfrentamiento);
    void eliminar(Long id);
    EnfrentamientoParticipante2vs2 buscarPorId(Long id);
    List<EnfrentamientoParticipante2vs2> listarPorEvento(Evento evento);
}
