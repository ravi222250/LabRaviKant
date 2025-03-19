package src.parkingLot.controller;

import src.parkingLot.Exception.GateNotFoundException;
import src.parkingLot.Exception.OperatorNotFoundException;
import src.parkingLot.Exception.ParkingLotNotFoundException;
import src.parkingLot.dto.ResponseStatus;
import src.parkingLot.dto.TicketRequestDto;
import src.parkingLot.dto.TicketResponseDto;
import src.parkingLot.model.Ticket;
import src.parkingLot.service.TicketService;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketResponseDto issueTicket(TicketRequestDto ticketRequestDto) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        try {
            Ticket ticket = ticketService.issueTicket(
                    ticketRequestDto.getOwnerName(),
                    ticketRequestDto.getVehicleType(),
                    ticketRequestDto.getLicensePlate(),
                    ticketRequestDto.getGateid(),
                    ticketRequestDto.getOperatorId(),
                    ticketRequestDto.getParkingStrategyType(),
                    ticketRequestDto.getParkingLotId()
            );
            ticketResponseDto.setTicketId(ticket.getId());
            ticketResponseDto.setParkingSlot(ticket.getParkingSlot());
            ticketResponseDto.setGate(ticket.getGate());
            ticketResponseDto.setOperator(ticket.getOperator());
            ticketResponseDto.setEntryTime(ticket.getEntryTime());

            ticketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (GateNotFoundException | OperatorNotFoundException |ParkingLotNotFoundException e) {
            ticketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return ticketResponseDto;
    }
}
