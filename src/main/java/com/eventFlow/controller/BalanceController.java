package com.eventFlow.controller;

import com.eventFlow.model.Evento;
import com.eventFlow.model.Gasto;
import com.eventFlow.service.BalanceService;
import com.eventFlow.service.EventoService;
import com.eventFlow.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private GastoService gastoService;

    @Autowired
    private BalanceService balanceService;

    @GetMapping
    public String seleccionarEvento(Model model) {
        model.addAttribute("eventos", eventoService.listarTodos());
        return "seleccionar_evento_balance";
    }

    @GetMapping("/evento/{id}")
    public String verBalance(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id);
        model.addAttribute("evento", evento);
        model.addAttribute("ingresos", balanceService.calcularIngresos(evento));
        model.addAttribute("gastos", balanceService.calcularGastos(evento));
        model.addAttribute("balance", balanceService.calcularBalance(evento));
        model.addAttribute("gastosLista", gastoService.listarPorEvento(id));
        model.addAttribute("nuevoGasto", new Gasto());
        return "balance";
    }

    @PostMapping("/guardar/{id}")
    public String guardarGasto(@ModelAttribute("nuevoGasto") Gasto gasto,
                               @PathVariable Long id) {
        gasto.setEvento(eventoService.buscarPorId(id));
        gastoService.guardar(gasto);
        return "redirect:/balance/evento/" + id;
    }

    @GetMapping("/eliminar/{idGasto}/{idEvento}")
    public String eliminar(@PathVariable Long idGasto, @PathVariable Long idEvento) {
        gastoService.eliminar(idGasto);
        return "redirect:/balance/evento/" + idEvento;
    }

    @GetMapping("/editar/{idGasto}/{idEvento}")
    public String editarGasto(@PathVariable Long idGasto, @PathVariable Long idEvento, Model model) {
        Evento evento = eventoService.buscarPorId(idEvento);

        model.addAttribute("evento", evento);
        model.addAttribute("ingresos", balanceService.calcularIngresos(evento));
        model.addAttribute("gastos", balanceService.calcularGastos(evento));
        model.addAttribute("balance", balanceService.calcularBalance(evento));
        model.addAttribute("gastosLista", gastoService.listarPorEvento(idEvento));
        model.addAttribute("editando", gastoService.listarPorEvento(idEvento).stream()
                .filter(g -> g.getIdGasto().equals(idGasto))
                .findFirst().orElse(null));

        return "balance";
    }

    @PostMapping("/update/{idEvento}")
    public String actualizarGasto(@ModelAttribute("editando") Gasto gasto,
                                  @PathVariable Long idEvento) {
        gasto.setEvento(eventoService.buscarPorId(idEvento));
        gastoService.guardar(gasto);
        return "redirect:/balance/evento/" + idEvento;
    }
}
