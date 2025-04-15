package com.eventFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        // Redirige siempre a /login al acceder a la raíz
        return "redirect:/login";
    }
}
