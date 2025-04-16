package com.eventFlow.service;

import com.eventFlow.model.Evento;

import java.util.List;

public interface EventoService {
    List<Evento> listarTodos();
    Evento buscarPorId(Long id);
    Evento guardar(Evento evento);
    void eliminar(Long id);
}
