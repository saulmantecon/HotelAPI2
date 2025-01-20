package org.example.hotelapi2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.hotelapi2.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class HotelApi2Application{

    public static void main(String[] args) {
        SpringApplication.run(HotelApi2Application.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class webSecurityConfig{

    }







}
