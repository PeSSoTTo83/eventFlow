package com.eventFlow.controller;

import com.eventFlow.model.CompaniaAseguradora;
import com.eventFlow.service.CompaniaAseguradoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/companias")
public class CompaniaAseguradoraController {

    @Autowired
    private CompaniaAseguradoraService service;

    // Listar todas las compañías
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("companias", service.listarTodas());
        return "companias"; // Vista: templates/companias.html
    }

    // Mostrar formulario de creación
    @GetMapping("/companias_formulario")
    public String nueva(Model model) {
        model.addAttribute("compania", new CompaniaAseguradora());
        return "companias_formulario"; // Vista: templates/companias_formulario.html
    }

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        CompaniaAseguradora compania = service.buscarPorId(id);
        if (compania != null) {
            model.addAttribute("compania", compania);
            return "companias_formulario";
        } else {
            return "redirect:/companias";
        }
    }

    // Guardar nueva o actualizada
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("compania") CompaniaAseguradora compania) {
        service.guardar(compania);
        return "redirect:/companias";
    }

    // Eliminar por ID
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/companias";
    }
}
