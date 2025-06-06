package com.pragma.microserviciousuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.pragma.microserviciousuarios.infrastructure.security.utils",
        "com.pragma.microserviciousuarios" // Otros paquetes necesarios
})
public class MicroservicioUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioUsuariosApplication.class, args);
    }

}
