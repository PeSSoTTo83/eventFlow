package com.eventFlow.service;

import com.eventFlow.model.TipoUsuario;

import java.util.List;

public interface TipoUsuarioService {
    List<TipoUsuario> findAll();
    TipoUsuario findById(Long id);
    TipoUsuario save(TipoUsuario tipoUsuario);
    void deleteById(Long id);
}
