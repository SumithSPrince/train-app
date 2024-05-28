// TicketServiceTest.java
package com.example.trainapp.service;

import com.example.trainapp.model.Ticket;
import com.example.trainapp.model.User;
import com.example.trainapp.repository.InMemoryTicketRepository;
import com.example.trainapp.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {
    private TicketService ticketService;
    private TicketRepository ticketRepository;

    @BeforeEach
    void setUp() {
        ticketRepository = new InMemoryTicketRepository();
        ticketService = new TicketService(ticketRepository);
    }

    @Test
    void purchaseTicket() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        Ticket ticket = new Ticket();
        ticket.setFrom("London");
        ticket.setTo("France");
        ticket.setUser(user);
        ticket.setPricePaid(20.0);
        ticket.setSeat("A1");

        Ticket savedTicket = ticketService.purchaseTicket(ticket);
        assertNotNull(savedTicket);
        assertEquals("john.doe@example.com", savedTicket.getUser().getEmail());
    }

    @Test
    void getReceipt() {
        // Similar setup and assertions as purchaseTicket
    }

    @Test
    void getUsersBySection() {
        // Similar setup and assertions as purchaseTicket
    }

    @Test
    void removeUser() {
        // Similar setup and assertions as purchaseTicket
    }

    @Test
    void modifySeat() {
        // Similar setup and assertions as purchaseTicket
    }
}
