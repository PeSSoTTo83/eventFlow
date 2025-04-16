package com.eventFlow.repository;

import com.eventFlow.model.EquipoMiembro;
import com.eventFlow.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoMiembroRepository extends JpaRepository<EquipoMiembro, Long> {
    List<EquipoMiembro> findByEquipo(Equipo equipo);
}
