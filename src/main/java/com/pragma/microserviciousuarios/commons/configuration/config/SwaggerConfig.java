package com.pragma.microserviciousuarios.commons.configuration.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio Usuarios")
                        .version("1.0")
                        .description("API para la gestión de usuarios en la plataforma Hogar 360")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación oficial")
                        .url("https://Microservicio-Usuarios.com/docs"));
    }
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("users")
                .packagesToScan("com.pragma.microserviciousuarios.infrastructure.endpoints.rest") // Escanea el paquete de UserController
                .build();
    }


}
