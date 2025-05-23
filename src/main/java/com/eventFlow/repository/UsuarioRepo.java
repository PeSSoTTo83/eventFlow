package com.eventFlow.repository;

import com.eventFlow.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
