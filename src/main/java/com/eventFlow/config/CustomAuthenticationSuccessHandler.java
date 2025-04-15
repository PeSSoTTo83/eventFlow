package com.eventFlow.config;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
                                        HttpServletResponse response, 
                                        Authentication authentication)
                                        throws IOException, ServletException {
        // Verificar si el usuario tiene ROLE_ADMIN
        boolean isAdmin = authentication.getAuthorities().stream()
                              .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin) {
            // Redirige a /index para admin
            response.sendRedirect(request.getContextPath() + "/index");
        } else {
            // Redirige a /reservausuario para usuario normal
            response.sendRedirect(request.getContextPath() + "/reservausuario");
        }
    }
}
