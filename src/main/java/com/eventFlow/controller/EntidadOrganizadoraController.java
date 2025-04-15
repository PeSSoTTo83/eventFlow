package com.eventFlow.controller;

import com.eventFlow.model.EntidadOrganizadora;
import com.eventFlow.service.EntidadOrganizadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entidades")
public class EntidadOrganizadoraController {

    @Autowired
    private EntidadOrganizadoraService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entidades", service.listarTodas());
        return "entidades";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("entidad", new EntidadOrganizadora());
        return "entidades_formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        EntidadOrganizadora entidad = service.buscarPorId(id);
        if (entidad != null) {
            model.addAttribute("entidad", entidad);
            return "entidades_formulario";
        } else {
            return "redirect:/entidades";
        }
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("entidad") EntidadOrganizadora entidad) {
        service.guardar(entidad);
        return "redirect:/entidades";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/entidades";
    }
}
