package com.eventFlow.controller;

import com.eventFlow.model.Evento;
import com.eventFlow.model.TipoClasificacion;
import com.eventFlow.repository.EventoRepository;
import com.eventFlow.repository.TipoClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clasificaciones")
public class ClasificacionController {

    @Autowired
    private EventoRepository eventoRepo;

    @Autowired
    private TipoClasificacionRepository tipoClasificacionRepo;

    @GetMapping
    public String seleccionarEvento(Model model) {
        List<Evento> eventos = eventoRepo.findAll();
        model.addAttribute("eventos", eventos);
        return "seleccionar_evento_clasificacion";
    }

    @GetMapping("/evento/{id}/tipo")
    public String seleccionarTipoClasificacion(@PathVariable Long id, Model model) {
        Evento evento = eventoRepo.findById(id).orElse(null);

        if (evento != null && evento.getTipoClasificacion() != null) {
            TipoClasificacion tipo = evento.getTipoClasificacion();
            if (tipo.getNombre().equalsIgnoreCase("General")) {
                return "redirect:/clasificaciones/general/" + evento.getIdEvento();
            } else {
                return "redirect:/clasificaciones/versus/" + evento.getIdEvento();
            }
        }

        List<TipoClasificacion> tipos = tipoClasificacionRepo.findAll();
        model.addAttribute("evento", evento);
        model.addAttribute("tipos", tipos);
        return "seleccionar_tipo_clasificacion";
    }


    @PostMapping("/evento/{id}/guardar-tipo")
    public String guardarTipoClasificacion(@PathVariable Long id, @RequestParam("tipoId") Long tipoId) {
        Evento evento = eventoRepo.findById(id).orElse(null);
        TipoClasificacion tipoSeleccionado = tipoClasificacionRepo.findById(tipoId).orElse(null);

        if (evento != null && tipoSeleccionado != null && evento.getTipoClasificacion() == null) {
            evento.setTipoClasificacion(tipoSeleccionado);
            eventoRepo.save(evento);

            if (tipoSeleccionado.getNombre().equalsIgnoreCase("Versus")) {
                return "redirect:/clasificaciones/versus/" + id;
            } else {
                return "redirect:/clasificaciones/general/" + id;
            }
        }

        return "redirect:/clasificaciones";
    }


    @GetMapping("/versus/{id}")
    public String seleccionarSubtipoVersus(@PathVariable Long id, Model model) {
        Evento evento = eventoRepo.findById(id).orElse(null);
        model.addAttribute("evento", evento);
        return "seleccionar_tipo_versus";
    }

    @PostMapping("/versus/{id}/tipo")
    public String redirigirSegunSubtipo(@PathVariable Long id, @RequestParam("subtipo") String subtipo) {
        return "redirect:/clasificaciones/versus-" + subtipo + "/" + id;
    }
    
    @PostMapping("/seleccionar-evento")
    public String redirigirDesdeSelector(@RequestParam Long eventoId) {
        return "redirect:/clasificaciones/evento/" + eventoId + "/tipo";
    }

}
