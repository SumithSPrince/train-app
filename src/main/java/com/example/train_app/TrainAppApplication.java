// TrainAppApplication.java
package com.example.trainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.trainapp.repository.InMemoryTicketRepository;
import com.example.trainapp.repository.TicketRepository;

@SpringBootApplication
public class TrainAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainAppApplication.class, args);
    }

    @Bean
    public TicketRepository ticketRepository() {
        return new InMemoryTicketRepository();
    }
}
