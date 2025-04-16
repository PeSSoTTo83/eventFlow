package com.eventFlow.controller;

import com.eventFlow.model.EnfrentamientoParticipante2vs2;
import com.eventFlow.model.Evento;
import com.eventFlow.model.Participante;
import com.eventFlow.service.Enfrentamiento2vs2Service;
import com.eventFlow.service.EventoService;
import com.eventFlow.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clasificaciones/versus-2vs2")
public class ClasificacionVersus2vs2Controller {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private Enfrentamiento2vs2Service enfrentamientoService;

    @GetMapping("/{id}")
    public String mostrar(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id);
        List<Participante> participantes = participanteService.listarPorEvento(evento);
        List<EnfrentamientoParticipante2vs2> enfrentamientos = enfrentamientoService.listarPorEvento(evento);

        model.addAttribute("evento", evento);
        model.addAttribute("participantes", participantes);
        model.addAttribute("enfrentamientos", enfrentamientos);
        model.addAttribute("nuevoEnfrentamiento", new EnfrentamientoParticipante2vs2());

        return "versus_2vs2";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute EnfrentamientoParticipante2vs2 enfrentamiento) {
        enfrentamientoService.guardar(enfrentamiento);
        return "redirect:/clasificaciones/versus-2vs2/" + enfrentamiento.getEvento().getIdEvento();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        EnfrentamientoParticipante2vs2 enfrentamiento = enfrentamientoService.buscarPorId(id);
        Long eventoId = enfrentamiento.getEvento().getIdEvento();
        enfrentamientoService.eliminar(id);
        return "redirect:/clasificaciones/versus-2vs2/" + eventoId;
    }
}
