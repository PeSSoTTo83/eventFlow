package com.eventFlow.controller;

import com.eventFlow.model.Evento;
import com.eventFlow.service.EventoService;
import com.eventFlow.service.EntidadOrganizadoraService;
import com.eventFlow.service.LocalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EntidadOrganizadoraService entidadService;

    @Autowired
    private LocalizacionService localizacionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("eventos", eventoService.listarTodos());
        return "eventos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("evento", new Evento());
        model.addAttribute("entidades", entidadService.listarTodas());
        model.addAttribute("localizaciones", localizacionService.listarTodas());
        return "eventos_formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("evento") Evento evento) {
        eventoService.guardar(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        eventoService.eliminar(id);
        return "redirect:/eventos";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id);
        if (evento != null) {
            model.addAttribute("evento", evento);
            model.addAttribute("entidades", entidadService.listarTodas());
            model.addAttribute("localizaciones", localizacionService.listarTodas());
            return "eventos_formulario";
        } else {
            return "redirect:/eventos";
        }
    }

}
