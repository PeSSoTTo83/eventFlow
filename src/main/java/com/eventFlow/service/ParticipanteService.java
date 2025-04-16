package com.eventFlow.service;

import com.eventFlow.model.Evento;
import com.eventFlow.model.Participante;

import java.util.List;

public interface ParticipanteService {
    List<Participante> listarTodos();
    Participante buscarPorId(Long id);
    Participante guardar(Participante participante);
    void eliminar(Long id);

    // ✅ Añadido
    List<Participante> listarPorEvento(Evento evento);
}
