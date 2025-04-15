package com.eventFlow.service;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.eventFlow.model.TipoUsuario;
import com.eventFlow.model.Usuario;
import com.eventFlow.repository.TipoUsuarioRepo;
import com.eventFlow.repository.UsuarioRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private TipoUsuarioRepo tipoUsuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscar usuario por email
        Usuario user = usuarioRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No existe usuario con email: " + email);
        }

        // Obtener el registro de tipoUsuario asociado
        Long idTipo = user.getTipousuario(); // ID de la fila en tipousuario
        TipoUsuario tU = tipoUsuarioRepo.findById(idTipo).orElse(null);
        if (tU == null) {
            throw new UsernameNotFoundException("No existe TipoUsuario con id=" + idTipo);
        }

        // Asignar rol según el ID del tipo:
        // ID 1 y 2: ADMIN, ID 3 y 4: USER (o cualquier otro)
        int tipoId = tU.getIdtipousuario().intValue();
        String springRole = (tipoId == 1 || tipoId == 2) ? "ADMIN" : "USER";

        // Crear la autoridad "ROLE_ADMIN" o "ROLE_USER"
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + springRole);

        // Devolver UserDetails con username, password y rol
        return new User(
                user.getEmail(),
                user.getContrasenya(),
                Collections.singletonList(authority)
        );
    }
}
