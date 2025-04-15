package com.eventFlow.service.impl;

import com.eventFlow.model.Localizacion;
import com.eventFlow.repository.LocalizacionRepository;
import com.eventFlow.service.LocalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacionServiceImpl implements LocalizacionService {

    @Autowired
    private LocalizacionRepository repository;

    @Override
    public List<Localizacion> listarTodas() {
        return repository.findAll();
    }

    @Override
    public Localizacion buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Localizacion guardar(Localizacion localizacion) {
        return repository.save(localizacion);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
