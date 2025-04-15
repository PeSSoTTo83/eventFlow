package com.eventFlow.repository;

import com.eventFlow.model.Localizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacionRepository extends JpaRepository<Localizacion, Long> {
}
