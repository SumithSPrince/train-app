// InMemoryTicketRepository.java
package com.example.trainapp.repository;

import com.example.trainapp.model.Ticket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTicketRepository implements TicketRepository {
    private final Map<String, Ticket> ticketStore = new HashMap<>();

    @Override
    public Ticket save(Ticket ticket) {
        ticketStore.put(ticket.getUser().getEmail(), ticket);
        return ticket;
    }

    @Override
    public Ticket findByEmail(String email) {
        return ticketStore.get(email);
    }

    @Override
    public List<Ticket> findBySection(String section) {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : ticketStore.values()) {
            if (ticket.getSeat().startsWith(section)) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    @Override
    public void deleteByEmail(String email) {
        ticketStore.remove(email);
    }

    @Override
    public void updateSeat(String email, String newSeat) {
        Ticket ticket = ticketStore.get(email);
        if (ticket != null) {
            ticket.setSeat(newSeat);
        }
    }
}
