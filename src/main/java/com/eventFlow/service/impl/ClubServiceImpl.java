package com.eventFlow.service.impl;

import com.eventFlow.model.Club;
import com.eventFlow.repository.ClubRepository;
import com.eventFlow.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository repository;

    @Override
    public List<Club> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Club buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Club guardar(Club club) {
        return repository.save(club);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
