package com.CEA.usuario_mascotas.adapter.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())   // Desactivar CSRF para permitir POST/PUT/DELETE desde API REST
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/login",
                    "/usuarios/crear",
                    "/usuarios/recuperar",
                    "/usuarios/cambiar-clave",
                    "/api/**",        // 👈 APIs REST públicas
                    "/css/**",
                    "/js/**"
                ).permitAll()
                .anyRequest().authenticated()    // Todo lo demás requiere autenticación
            )
            .formLogin(form -> form
                .loginPage("/login")               // Tu login MVC personalizado
                .loginProcessingUrl("/login")       // Donde Spring procesa el POST del login
                .defaultSuccessUrl("/usuarios/listar", true)  // A dónde redirige luego de iniciar sesión
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout") // Adónde ir luego de cerrar sesión
                .permitAll()
            );

        return http.build();
    }
}



