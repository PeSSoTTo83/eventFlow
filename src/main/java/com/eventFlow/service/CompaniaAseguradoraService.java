package com.eventFlow.service;

import com.eventFlow.model.CompaniaAseguradora;

import java.util.List;

public interface CompaniaAseguradoraService {
    List<CompaniaAseguradora> listarTodas();
    CompaniaAseguradora buscarPorId(Long id);
    CompaniaAseguradora guardar(CompaniaAseguradora compania);
    void eliminar(Long id);
}
