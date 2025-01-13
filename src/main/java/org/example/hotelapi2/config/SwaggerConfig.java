package org.example.hotelapi2.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Hotel API 2")
                        .description("Hotel API 2")
                        .contact(new Contact().name("Saul")
                                .email("saul@gmail.com")
                                .url("https://github.com/saul"))
                        .version("1.0"));
    }
}
