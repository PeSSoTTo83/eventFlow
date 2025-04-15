package com.eventFlow.service.impl;

import com.eventFlow.model.Usuario;
import com.eventFlow.repository.UsuarioRepo;
import com.eventFlow.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepo.deleteById(id);
    }
}
