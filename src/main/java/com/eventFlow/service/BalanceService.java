package com.eventFlow.service;

import com.eventFlow.model.Evento;

public interface BalanceService {
    Double calcularIngresos(Evento evento);
    Double calcularGastos(Evento evento);
    Double calcularBalance(Evento evento);
}
