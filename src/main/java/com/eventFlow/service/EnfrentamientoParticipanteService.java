package com.eventFlow.service;

import com.eventFlow.model.EnfrentamientoParticipante;
import com.eventFlow.model.Evento;

import java.util.List;

public interface EnfrentamientoParticipanteService {
    List<EnfrentamientoParticipante> listarPorEvento(Evento evento);
    void guardar(EnfrentamientoParticipante enfrentamiento);
    void eliminar(Long id);
    EnfrentamientoParticipante buscarPorId(Long id);
}
