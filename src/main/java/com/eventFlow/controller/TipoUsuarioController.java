package com.eventFlow.controller;

import com.eventFlow.model.TipoUsuario;
import com.eventFlow.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipousuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public String findAll(Model model) {
        // Lista de tipos de usuario
        List<TipoUsuario> lista = tipoUsuarioService.findAll();
        model.addAttribute("tipoUsuarios", lista);
        return "tipoUsuario"; // Nombre de la plantilla Thymeleaf
    }

    @PostMapping
    public String save(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioService.save(tipoUsuario);
        return "redirect:/tipousuario";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        tipoUsuarioService.deleteById(id);
        return "redirect:/tipousuario";
    }

    // NUEVO: Mostrar formulario de edición
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioService.findById(id);
        model.addAttribute("tipoUsuario", tipoUsuario);
        return "editarTipoUsuario"; // Nombre de la vista de edición
    }

    // NUEVO: Actualizar los datos del tipo de usuario
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuario.setIdtipousuario(id); // Asegurar que se mantiene el ID
        tipoUsuarioService.save(tipoUsuario);
        return "redirect:/tipousuario";
    }
}
