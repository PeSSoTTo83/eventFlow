package com.eventFlow.controller;

import com.eventFlow.model.ClasificacionGeneral;
import com.eventFlow.model.Evento;
import com.eventFlow.model.Participante;
import com.eventFlow.service.ClasificacionGeneralService;
import com.eventFlow.service.EventoService;
import com.eventFlow.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clasificaciones/general")
public class ClasificacionGeneralController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private ClasificacionGeneralService clasificacionGeneralService;

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping("/{id}")
    public String mostrarClasificacionGeneral(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id);
        List<ClasificacionGeneral> clasificados = clasificacionGeneralService.listarPorEventoOrdenado(evento);

        List<Participante> disponibles = participanteService.listarPorEvento(evento).stream()
                .filter(p -> clasificados.stream()
                        .noneMatch(c -> c.getParticipante().getIdParticipante().equals(p.getIdParticipante())))
                .collect(Collectors.toList());

        model.addAttribute("evento", evento);
        model.addAttribute("clasificados", clasificados);
        model.addAttribute("disponibles", disponibles);
        model.addAttribute("editando", null);

        return "clasificacion_general";
    }

    @PostMapping("/{id}/guardar")
    public String guardar(@PathVariable Long id,
                          @RequestParam Long participanteId,
                          @RequestParam boolean clasificado) {
        Evento evento = eventoService.buscarPorId(id);
        Participante participante = participanteService.buscarPorId(participanteId);

        ClasificacionGeneral clasificacion = new ClasificacionGeneral();
        clasificacion.setEvento(evento);
        clasificacion.setParticipante(participante);
        clasificacion.setClasificado(clasificado);

        clasificacionGeneralService.guardar(clasificacion);
        return "redirect:/clasificaciones/general/" + id;
    }

    @GetMapping("/{eventoId}/editar/{clasificacionId}")
    public String editar(@PathVariable Long eventoId,
                         @PathVariable Long clasificacionId,
                         Model model) {
        Evento evento = eventoService.buscarPorId(eventoId);
        ClasificacionGeneral editando = clasificacionGeneralService.buscarPorId(clasificacionId);
        List<ClasificacionGeneral> clasificados = clasificacionGeneralService.listarPorEventoOrdenado(evento);

        List<Participante> disponibles = participanteService.listarPorEvento(evento).stream()
                .filter(p -> clasificados.stream()
                        .noneMatch(c -> c.getParticipante().getIdParticipante().equals(p.getIdParticipante()))
                        || p.getIdParticipante().equals(editando.getParticipante().getIdParticipante()))
                .collect(Collectors.toList());

        model.addAttribute("evento", evento);
        model.addAttribute("clasificados", clasificados);
        model.addAttribute("disponibles", disponibles);
        model.addAttribute("editando", editando);

        return "clasificacion_general";
    }

    @PostMapping("/{eventoId}/actualizar/{clasificacionId}")
    public String actualizar(@PathVariable Long eventoId,
                             @PathVariable Long clasificacionId,
                             @RequestParam Long participanteId,
                             @RequestParam boolean clasificado) {
        Evento evento = eventoService.buscarPorId(eventoId);
        Participante participante = participanteService.buscarPorId(participanteId);
        ClasificacionGeneral clasificacion = clasificacionGeneralService.buscarPorId(clasificacionId);

        clasificacion.setParticipante(participante);
        clasificacion.setClasificado(clasificado);

        if (!clasificado) {
            clasificacion.setPosicion(null);
        } else if (!clasificacion.isClasificado()) {
            clasificacion.setPosicion(null);
        }

        clasificacionGeneralService.guardar(clasificacion);
        return "redirect:/clasificaciones/general/" + eventoId;
    }

    @GetMapping("/{eventoId}/eliminar/{clasificacionId}")
    public String eliminar(@PathVariable Long eventoId,
                           @PathVariable Long clasificacionId) {
        clasificacionGeneralService.eliminar(clasificacionId);
        return "redirect:/clasificaciones/general/" + eventoId;
    }
}
