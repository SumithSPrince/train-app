// TicketRepository.java
package com.example.trainapp.repository;

import com.example.trainapp.model.Ticket;
import java.util.List;

public interface TicketRepository {
    Ticket save(Ticket ticket);
    Ticket findByEmail(String email);
    List<Ticket> findBySection(String section);
    void deleteByEmail(String email);
    void updateSeat(String email, String newSeat);
}
