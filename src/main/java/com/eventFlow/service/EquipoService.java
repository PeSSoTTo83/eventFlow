package com.eventFlow.service;

import com.eventFlow.model.Equipo;
import com.eventFlow.model.Evento;

import java.util.List;

public interface EquipoService {
    List<Equipo> listarPorEvento(Evento evento);
    Equipo guardar(Equipo equipo);
    Equipo buscarPorId(Long id);
}
