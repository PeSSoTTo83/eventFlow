package com.eventFlow.service;

import com.eventFlow.model.Club;

import java.util.List;

public interface ClubService {
    List<Club> listarTodos();
    Club buscarPorId(Long id);
    Club guardar(Club club);
    void eliminar(Long id);
}
