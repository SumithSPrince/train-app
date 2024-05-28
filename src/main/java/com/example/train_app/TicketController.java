// TicketController.java
package com.example.trainapp.controller;

import com.example.trainapp.model.Ticket;
import com.example.trainapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody Ticket ticket) {
        return ticketService.purchaseTicket(ticket);
    }

    @GetMapping("/receipt/{email}")
    public Ticket getReceipt(@PathVariable String email) {
        return ticketService.getReceipt(email);
    }

    @GetMapping("/section/{section}")
    public List<Ticket> getUsersBySection(@PathVariable String section) {
        return ticketService.getUsersBySection(section);
    }

    @DeleteMapping("/remove/{email}")
    public void removeUser(@PathVariable String email) {
        ticketService.removeUser(email);
    }

    @PutMapping("/modify-seat")
    public void modifySeat(@RequestParam String email, @RequestParam String newSeat) {
        ticketService.modifySeat(email, newSeat);
    }
}
