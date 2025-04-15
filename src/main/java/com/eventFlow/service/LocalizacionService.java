package com.eventFlow.service;

import com.eventFlow.model.Localizacion;

import java.util.List;

public interface LocalizacionService {
    List<Localizacion> listarTodas();
    Localizacion buscarPorId(Long id);
    Localizacion guardar(Localizacion localizacion);
    void eliminar(Long id);
}
