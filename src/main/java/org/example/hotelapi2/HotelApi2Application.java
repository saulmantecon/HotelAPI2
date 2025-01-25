package org.example.hotelapi2;

import org.example.hotelapi2.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class HotelApi2Application{

    public static void main(String[] args) {
        SpringApplication.run(HotelApi2Application.class, args);
    }


    @Configuration
    public static class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf().disable() // Deshabilita CSRF (solo si es necesario)
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers(HttpMethod.POST, "/user").permitAll()
                            .requestMatchers(HttpMethod.GET, "/hotelPorCategoria/{categoria}").permitAll()
                            .requestMatchers(HttpMethod.GET, "habitacion/{tamano}/{preciomin}/{preciomax}").permitAll()
                            .requestMatchers( "/doc/**").permitAll()
                            .requestMatchers( "/v3/**").permitAll() //v3 documentos (info)
                            .anyRequest().authenticated()// Todo lo demás requiere autenticación
                    );
            return http.build();
        }
    }
}
