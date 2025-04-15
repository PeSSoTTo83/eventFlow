package com.eventFlow.service.impl;

import com.eventFlow.model.TipoUsuario;
import com.eventFlow.repository.TipoUsuarioRepo;
import com.eventFlow.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepo tipoUsuarioRepo;

    @Override
    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepo.findAll();
    }

    @Override
    public TipoUsuario findById(Long id) {
        return tipoUsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepo.save(tipoUsuario);
    }

    @Override
    public void deleteById(Long id) {
        tipoUsuarioRepo.deleteById(id);
    }
}
