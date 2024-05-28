// TicketService.java
package com.example.trainapp.service;

import com.example.trainapp.model.Ticket;
import com.example.trainapp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket purchaseTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getReceipt(String email) {
        return ticketRepository.findByEmail(email);
    }

    public List<Ticket> getUsersBySection(String section) {
        return ticketRepository.findBySection(section);
    }

    public void removeUser(String email) {
        ticketRepository.deleteByEmail(email);
    }

    public void modifySeat(String email, String newSeat) {
        ticketRepository.updateSeat(email, newSeat);
    }
}
