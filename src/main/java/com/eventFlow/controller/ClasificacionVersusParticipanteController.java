package com.eventFlow.controller;

import com.eventFlow.model.EnfrentamientoParticipante1vs1;
import com.eventFlow.model.Evento;
import com.eventFlow.model.Participante;
import com.eventFlow.service.Enfrentamiento1vs1Service;
import com.eventFlow.service.EventoService;
import com.eventFlow.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clasificaciones/versus-participantes")
public class ClasificacionVersusParticipanteController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private Enfrentamiento1vs1Service enfrentamientoService;

    @GetMapping("/{id}")
    public String mostrar(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id);
        List<Participante> participantes = participanteService.listarPorEvento(evento);
        List<EnfrentamientoParticipante1vs1> enfrentamientos = enfrentamientoService.listarPorEvento(evento);

        model.addAttribute("evento", evento);
        model.addAttribute("participantes", participantes);
        model.addAttribute("enfrentamientos", enfrentamientos);
        model.addAttribute("nuevoEnfrentamiento", new EnfrentamientoParticipante1vs1());

        return "versus_1vs1";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute EnfrentamientoParticipante1vs1 enfrentamiento) {
        enfrentamientoService.guardar(enfrentamiento);
        return "redirect:/clasificaciones/versus-participantes/" + enfrentamiento.getEvento().getIdEvento();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        EnfrentamientoParticipante1vs1 enfrentamiento = enfrentamientoService.buscarPorId(id);
        Long eventoId = enfrentamiento.getEvento().getIdEvento();
        enfrentamientoService.eliminar(id);
        return "redirect:/clasificaciones/versus-participantes/" + eventoId;
    }
}
