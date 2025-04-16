package com.eventFlow.service.impl;

import com.eventFlow.model.ClasificacionGeneral;
import com.eventFlow.model.Evento;
import com.eventFlow.repository.ClasificacionGeneralRepository;
import com.eventFlow.service.ClasificacionGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ClasificacionGeneralServiceImpl implements ClasificacionGeneralService {

    @Autowired
    private ClasificacionGeneralRepository repo;

    @Override
    public ClasificacionGeneral guardar(ClasificacionGeneral clasificacion) {
        if (clasificacion.isClasificado()) {
            int siguientePosicion = repo.findByEvento(clasificacion.getEvento()).stream()
                    .filter(c -> c.isClasificado() && c.getPosicion() != null)
                    .mapToInt(ClasificacionGeneral::getPosicion)
                    .max()
                    .orElse(0) + 1;

            clasificacion.setPosicion(siguientePosicion);
        } else {
            clasificacion.setPosicion(null);
        }

        return repo.save(clasificacion);
    }

    @Override
    public List<ClasificacionGeneral> listarPorEventoOrdenado(Evento evento) {
        return repo.findByEvento(evento).stream()
                .sorted(Comparator.comparing(ClasificacionGeneral::isClasificado).reversed()
                        .thenComparing(c -> c.getPosicion() != null ? c.getPosicion() : Integer.MAX_VALUE))
                .toList();
    }

    @Override
    public ClasificacionGeneral buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        ClasificacionGeneral eliminado = repo.findById(id).orElse(null);

        if (eliminado != null) {
            Evento evento = eliminado.getEvento();
            repo.delete(eliminado);

            // Reordenar posiciones después de eliminar
            List<ClasificacionGeneral> clasificados = repo.findByEvento(evento).stream()
                    .filter(ClasificacionGeneral::isClasificado)
                    .sorted((a, b) -> {
                        // Si alguno tiene posición nula lo mandamos al final
                        if (a.getPosicion() == null) return 1;
                        if (b.getPosicion() == null) return -1;
                        return Integer.compare(a.getPosicion(), b.getPosicion());
                    })
                    .toList();

            // Asignar nuevas posiciones consecutivas
            for (int i = 0; i < clasificados.size(); i++) {
                ClasificacionGeneral c = clasificados.get(i);
                c.setPosicion(i + 1);
                repo.save(c);
            }
        }
    }

}
