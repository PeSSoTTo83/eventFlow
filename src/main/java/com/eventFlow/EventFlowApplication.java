package com.eventFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventFlowApplication.class, args);
        System.out.println("Servidor escuchando en http://localhost:8080");
    }
}
