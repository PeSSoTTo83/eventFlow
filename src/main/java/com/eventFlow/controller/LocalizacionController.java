package com.eventFlow.controller;

import com.eventFlow.model.Localizacion;
import com.eventFlow.service.LocalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/localizaciones")
public class LocalizacionController {

    @Autowired
    private LocalizacionService localizacionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("localizaciones", localizacionService.listarTodas());
        return "localizaciones";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("localizacion", new Localizacion());
        return "localizaciones_formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Localizacion localizacion = localizacionService.buscarPorId(id);
        if (localizacion != null) {
            model.addAttribute("localizacion", localizacion);
            return "localizaciones_formulario";
        } else {
            return "redirect:/localizaciones";
        }
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("localizacion") Localizacion localizacion) {
        localizacionService.guardar(localizacion);
        return "redirect:/localizaciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        localizacionService.eliminar(id);
        return "redirect:/localizaciones";
    }
}
