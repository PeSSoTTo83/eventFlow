package com.eventFlow.service.impl;

import com.eventFlow.model.CompaniaAseguradora;
import com.eventFlow.repository.CompaniaAseguradoraRepository;
import com.eventFlow.service.CompaniaAseguradoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompaniaAseguradoraServiceImpl implements CompaniaAseguradoraService {

    @Autowired
    private CompaniaAseguradoraRepository repository;

    @Override
    public List<CompaniaAseguradora> listarTodas() {
        return repository.findAll();
    }

    @Override
    public CompaniaAseguradora buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CompaniaAseguradora guardar(CompaniaAseguradora compania) {
        return repository.save(compania);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
