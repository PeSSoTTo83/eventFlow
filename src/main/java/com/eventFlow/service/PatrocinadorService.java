package com.eventFlow.service;

import com.eventFlow.model.Patrocinador;

import java.util.List;

public interface PatrocinadorService {
    List<Patrocinador> listarTodos();
    Patrocinador buscarPorId(Long id);
    Patrocinador guardar(Patrocinador patrocinador);
    void eliminar(Long id);
}
