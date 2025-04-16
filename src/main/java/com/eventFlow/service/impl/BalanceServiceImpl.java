package com.eventFlow.service.impl;

import com.eventFlow.model.Evento;
import com.eventFlow.model.Gasto;
import com.eventFlow.model.Patrocinador;
import com.eventFlow.service.BalanceService;
import com.eventFlow.service.GastoService;
import com.eventFlow.service.PatrocinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private PatrocinadorService patrocinadorService;

    @Autowired
    private GastoService gastoService;

    @Override
    public Double calcularIngresos(Evento evento) {
        double ingresosInscripciones = evento.getNumParticipantes() * evento.getPrecioInscripcion();

        double totalPatrocinio = patrocinadorService.listarTodos().stream()
                .filter(p -> p.getEvento().getIdEvento().equals(evento.getIdEvento()))
                .mapToDouble(Patrocinador::getImportePatrocinio)
                .sum();

        return ingresosInscripciones + totalPatrocinio;
    }

    @Override
    public Double calcularGastos(Evento evento) {
        List<Gasto> gastos = gastoService.listarPorEvento(evento.getIdEvento());
        return gastos.stream().mapToDouble(Gasto::getImporte).sum();
    }

    @Override
    public Double calcularBalance(Evento evento) {
        return calcularIngresos(evento) - calcularGastos(evento);
    }
}
