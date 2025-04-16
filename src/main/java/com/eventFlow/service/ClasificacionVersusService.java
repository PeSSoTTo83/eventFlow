package com.eventFlow.service;

import com.eventFlow.model.ClasificacionVersus;
import com.eventFlow.model.Evento;

import java.util.List;

public interface ClasificacionVersusService {
    List<ClasificacionVersus> listarPorEvento(Evento evento);
    ClasificacionVersus guardar(ClasificacionVersus cv);
}
