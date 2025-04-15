package com.eventFlow.controller;

import com.eventFlow.model.Club;
import com.eventFlow.model.Federacion;
import com.eventFlow.service.ClubService;
import com.eventFlow.service.FederacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @Autowired
    private FederacionService federacionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clubes", clubService.listarTodos());
        return "clubes";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("federaciones", federacionService.listarTodas());
        return "clubes_formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Club club = clubService.buscarPorId(id);
        if (club != null) {
            model.addAttribute("club", club);
            model.addAttribute("federaciones", federacionService.listarTodas());
            return "clubes_formulario";
        } else {
            return "redirect:/clubes";
        }
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club, @RequestParam("federacionId") Long federacionId) {
        Federacion federacion = federacionService.buscarPorId(federacionId);
        club.setFederacion(federacion);
        clubService.guardar(club);
        return "redirect:/clubes";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        clubService.eliminar(id);
        return "redirect:/clubes";
    }
}
