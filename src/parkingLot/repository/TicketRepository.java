package src.parkingLot.repository;

import src.parkingLot.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    private final List<Ticket> tickets;
    private static Integer IDCounter = 0;

    public TicketRepository () {
        tickets = new ArrayList<>();
    }

    public Ticket save(Ticket ticket) {
        ticket.setId(IDCounter++);
        tickets.add(ticket);
        return ticket;
    }

}
