package src.parkingLot.dto;

import lombok.Getter;
import lombok.Setter;
import src.parkingLot.model.Gate;
import src.parkingLot.model.Operator;
import src.parkingLot.model.ParkingFloor;
import src.parkingLot.model.ParkingSlot;

import java.time.LocalDateTime;

@Getter
@Setter
public class TicketResponseDto {

    private ResponseStatus responseStatus;
    private Integer ticketId;
    private ParkingSlot parkingSlot;
    private Operator operator;
    private LocalDateTime entryTime;
    private Gate gate;
}
