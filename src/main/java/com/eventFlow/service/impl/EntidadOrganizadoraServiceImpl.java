package com.eventFlow.service.impl;

import com.eventFlow.model.EntidadOrganizadora;
import com.eventFlow.repository.EntidadOrganizadoraRepository;
import com.eventFlow.service.EntidadOrganizadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadOrganizadoraServiceImpl implements EntidadOrganizadoraService {

    @Autowired
    private EntidadOrganizadoraRepository repository;

    @Override
    public List<EntidadOrganizadora> listarTodas() {
        return repository.findAll();
    }

    @Override
    public EntidadOrganizadora buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EntidadOrganizadora guardar(EntidadOrganizadora entidad) {
        return repository.save(entidad);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
