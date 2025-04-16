package com.eventFlow.service.impl;

import com.eventFlow.model.TipoClasificacion;
import com.eventFlow.repository.TipoClasificacionRepository;
import com.eventFlow.service.TipoClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoClasificacionServiceImpl implements TipoClasificacionService {

    @Autowired
    private TipoClasificacionRepository repo;

    @Override
    public List<TipoClasificacion> listarTodos() {
        return repo.findAll();
    }

    @Override
    public TipoClasificacion buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public TipoClasificacion buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }
}
