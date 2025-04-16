package com.eventFlow.service.impl;

import com.eventFlow.model.Gasto;
import com.eventFlow.repository.GastoRepository;
import com.eventFlow.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoServiceImpl implements GastoService {

    @Autowired
    private GastoRepository repo;

    @Override
    public List<Gasto> listarPorEvento(Long idEvento) {
        return repo.findAll().stream()
                .filter(g -> g.getEvento().getIdEvento().equals(idEvento))
                .toList();
    }

    @Override
    public Gasto guardar(Gasto gasto) {
        return repo.save(gasto);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
