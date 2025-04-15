package com.eventFlow.controller;

import com.eventFlow.model.CompaniaAseguradora;
import com.eventFlow.model.Federacion;
import com.eventFlow.service.CompaniaAseguradoraService;
import com.eventFlow.service.FederacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/federaciones")
public class FederacionController {

    @Autowired
    private FederacionService federacionService;

    @Autowired
    private CompaniaAseguradoraService companiaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("federaciones", federacionService.listarTodas());
        return "federaciones";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("federacion", new Federacion());
        model.addAttribute("companias", companiaService.listarTodas());
        return "federaciones_formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Federacion federacion = federacionService.buscarPorId(id);
        if (federacion != null) {
            model.addAttribute("federacion", federacion);
            model.addAttribute("companias", companiaService.listarTodas());
            return "federaciones_formulario";
        } else {
            return "redirect:/federaciones";
        }
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("federacion") Federacion federacion) {
        federacionService.guardar(federacion);
        return "redirect:/federaciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        federacionService.eliminar(id);
        return "redirect:/federaciones";
    }
}
