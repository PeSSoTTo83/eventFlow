package com.eventFlow.service;

import com.eventFlow.model.Gasto;
import java.util.List;

public interface GastoService {
    List<Gasto> listarPorEvento(Long idEvento);
    Gasto guardar(Gasto gasto);
    void eliminar(Long id);
}
