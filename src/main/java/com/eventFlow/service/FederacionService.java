package com.eventFlow.service;

import com.eventFlow.model.Federacion;

import java.util.List;

public interface FederacionService {
    List<Federacion> listarTodas();
    Federacion buscarPorId(Long id);
    Federacion guardar(Federacion federacion);
    void eliminar(Long id);
}
