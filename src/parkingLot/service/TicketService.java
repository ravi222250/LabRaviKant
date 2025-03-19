package src.parkingLot.service;

import src.parkingLot.Exception.GateNotFoundException;
import src.parkingLot.Exception.OperatorNotFoundException;
import src.parkingLot.Exception.ParkingLotNotFoundException;
import src.parkingLot.model.*;
import src.parkingLot.repository.TicketRepository;
import src.parkingLot.strategy.ParkingStrategyType;

import java.time.LocalDateTime;

public class TicketService {

    private final GateService gateService;
    private final OperatorService operatorService;
    private final VehicleService vehicleService;
    private final TicketRepository ticketRepository;
    private final ParkingLotService parkingLotService;

    public TicketService(GateService gateService,
                         OperatorService operatorService,
                         VehicleService vehicleService,
                         TicketRepository ticketRepository,
                         ParkingLotService parkingLotService) {
        this.gateService = gateService;
        this.operatorService = operatorService;
        this.vehicleService = vehicleService;
        this.ticketRepository = ticketRepository;
        this.parkingLotService = parkingLotService;
    }

    public Ticket issueTicket (
            String ownerName,
            VehicleType vehicleType,
            String licensePlate,
            Integer gateId,
            Integer operatorId,
            ParkingStrategyType parkingStrategyType,
            Integer parkingLotId
    ) throws GateNotFoundException, OperatorNotFoundException, ParkingLotNotFoundException {
        Gate gate = gateService.findGateById(gateId);
        Operator operator = operatorService.findOperatorById(operatorId);
        Vehicle vehicle = vehicleService.findVehicleByLicensePlate(licensePlate).isPresent() ?
                vehicleService.findVehicleByLicensePlate(licensePlate).get()
                : vehicleService.save(ownerName, licensePlate, vehicleType);

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());

        ParkingLot parkingLot = parkingLotService.getParkingLotById(parkingLotId);
        ParkingSlot parkingSlotFound
                = parkingLotService.findAvailableParkingLot(parkingStrategyType, parkingLot, vehicleType)
                .orElseThrow(() -> new ParkingLotNotFoundException("parking lot was not found!!"));

        ticket.setParkingSlot(parkingSlotFound);

        return ticketRepository.save(ticket);
    }
}
