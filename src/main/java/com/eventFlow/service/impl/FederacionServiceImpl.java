package com.eventFlow.service.impl;

import com.eventFlow.model.Federacion;
import com.eventFlow.repository.FederacionRepository;
import com.eventFlow.service.FederacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FederacionServiceImpl implements FederacionService {

    @Autowired
    private FederacionRepository repository;

    @Override
    public List<Federacion> listarTodas() {
        return repository.findAll();
    }

    @Override
    public Federacion buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Federacion guardar(Federacion federacion) {
        return repository.save(federacion);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
