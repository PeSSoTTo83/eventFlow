package com.eventFlow.service;

import com.eventFlow.model.ClasificacionGeneral;
import com.eventFlow.model.Evento;

import java.util.List;

public interface ClasificacionGeneralService {
    ClasificacionGeneral guardar(ClasificacionGeneral clasificacion);
    List<ClasificacionGeneral> listarPorEventoOrdenado(Evento evento);
    ClasificacionGeneral buscarPorId(Long id);
    void eliminar(Long id);
}
