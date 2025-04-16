package com.eventFlow.repository;

import com.eventFlow.model.TipoClasificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoClasificacionRepository extends JpaRepository<TipoClasificacion, Long> {
    TipoClasificacion findByNombre(String nombre);
}
