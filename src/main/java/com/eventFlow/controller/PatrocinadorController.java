package com.eventFlow.controller;

import com.eventFlow.model.Evento;
import com.eventFlow.model.Patrocinador;
import com.eventFlow.service.EventoService;
import com.eventFlow.service.PatrocinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patrocinadores")
public class PatrocinadorController {

    @Autowired
    private PatrocinadorService patrocinadorService;

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public String seleccionarEvento(Model model) {
        model.addAttribute("eventos", eventoService.listarTodos());
        return "seleccionar_evento_patrocinador";
    }

    @GetMapping("/evento/{id}")
    public String listarPorEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id);
        List<Patrocinador> patrocinadores = patrocinadorService.listarTodos().stream()
                .filter(p -> p.getEvento().getIdEvento().equals(id)).toList();

        model.addAttribute("evento", evento);
        model.addAttribute("patrocinadores", patrocinadores);
        model.addAttribute("patrocinador", new Patrocinador());
        return "patrocinadores";
    }

    @PostMapping("/guardar/{eventoId}")
    public String guardar(@ModelAttribute("patrocinador") Patrocinador patrocinador,
                          @PathVariable Long eventoId) {
        patrocinador.setEvento(eventoService.buscarPorId(eventoId));
        patrocinadorService.guardar(patrocinador);
        return "redirect:/patrocinadores/evento/" + eventoId;
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Patrocinador p = patrocinadorService.buscarPorId(id);
        Evento evento = p.getEvento();

        List<Patrocinador> patrocinadores = patrocinadorService.listarTodos().stream()
                .filter(pa -> pa.getEvento().getIdEvento().equals(evento.getIdEvento())).toList();

        model.addAttribute("evento", evento);
        model.addAttribute("patrocinador", p);
        model.addAttribute("patrocinadores", patrocinadores);

        return "patrocinadores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Patrocinador p = patrocinadorService.buscarPorId(id);
        Long eventoId = p.getEvento().getIdEvento();
        patrocinadorService.eliminar(id);
        return "redirect:/patrocinadores/evento/" + eventoId;
    }
}
