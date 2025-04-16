package com.eventFlow.service;

import com.eventFlow.model.TipoClasificacion;
import java.util.List;

public interface TipoClasificacionService {
    List<TipoClasificacion> listarTodos();
    TipoClasificacion buscarPorId(Long id);
    TipoClasificacion buscarPorNombre(String nombre);
}
