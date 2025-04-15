package com.eventFlow.controller;

import com.eventFlow.model.Usuario;
import com.eventFlow.repository.TipoUsuarioRepo;
import com.eventFlow.repository.UsuarioRepo;
import com.eventFlow.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private TipoUsuarioRepo tipoUsuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    // Muestra la pantalla de login (login.html)
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Muestra el formulario de registro
    @GetMapping("/usuario/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    // Procesa el registro
    @PostMapping("/usuario/saveUser")
    public String save(@ModelAttribute("usuario") Usuario usuario) {
        // Encriptar contraseña
        String passwordPlano = usuario.getContrasenya();
        String passwordEncriptado = passwordEncoder.encode(passwordPlano);
        usuario.setContrasenya(passwordEncriptado);

        // Asignar tipousuario por defecto si es nulo (ajusta según corresponda)
        if (usuario.getTipousuario() == null) {
            usuario.setTipousuario(3L);
        }

        // Asignar "activo" por defecto si es nulo
        if (usuario.getActivo() == null) {
            usuario.setActivo("1");
        }

        // Guardar el usuario
        usuarioService.save(usuario);

        // Redirige a /usuario (o a /login, según tu flujo)
        return "redirect:/login";
    }
}
