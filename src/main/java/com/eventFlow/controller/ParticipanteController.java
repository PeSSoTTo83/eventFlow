package com.eventFlow.controller;

import com.eventFlow.model.Evento;
import com.eventFlow.model.Participante;
import com.eventFlow.service.ClubService;
import com.eventFlow.service.EventoService;
import com.eventFlow.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private ClubService clubService;

    @Autowired
    private EventoService eventoService;

    // Paso 1: Elegir evento
    @GetMapping
    public String seleccionarEvento(Model model) {
        model.addAttribute("eventos", eventoService.listarTodos());
        return "seleccionar_evento";
    }

    // Paso 2: Mostrar listado y formulario de ese evento
    @GetMapping("/evento/{id}")
    public String listarPorEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id);
        List<Participante> participantes = participanteService.listarTodos()
                .stream().filter(p -> p.getEvento().getIdEvento().equals(id)).toList();

        model.addAttribute("participantes", participantes);
        model.addAttribute("evento", evento);
        model.addAttribute("participante", new Participante());
        model.addAttribute("clubes", clubService.listarTodos());
        return "participantes";
    }

    // Guardar participante vinculado al evento
    @PostMapping("/guardar/{eventoId}")
    public String guardar(@ModelAttribute("participante") Participante participante,
                          @PathVariable Long eventoId) {

        Evento evento = eventoService.buscarPorId(eventoId);
        participante.setEvento(evento);
        participanteService.guardar(participante);
        return "redirect:/participantes/evento/" + eventoId;
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Participante participante = participanteService.buscarPorId(id);
        Long eventoId = participante.getEvento().getIdEvento();

        model.addAttribute("participante", participante);
        model.addAttribute("clubes", clubService.listarTodos());
        model.addAttribute("evento", participante.getEvento());
        model.addAttribute("participantes", participanteService.listarTodos().stream()
                .filter(p -> p.getEvento().getIdEvento().equals(eventoId)).toList());

        return "participantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Participante p = participanteService.buscarPorId(id);
        Long eventoId = p.getEvento().getIdEvento();
        participanteService.eliminar(id);
        return "redirect:/participantes/evento/" + eventoId;
    }
}
