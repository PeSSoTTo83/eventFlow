package com.eventFlow.service;

import com.eventFlow.model.EntidadOrganizadora;

import java.util.List;

public interface EntidadOrganizadoraService {
    List<EntidadOrganizadora> listarTodas();
    EntidadOrganizadora buscarPorId(Long id);
    EntidadOrganizadora guardar(EntidadOrganizadora entidad);
    void eliminar(Long id);
}
