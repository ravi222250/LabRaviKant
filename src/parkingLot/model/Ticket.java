package src.parkingLot.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Ticket extends BaseModel {
    private Vehicle vehicle;
    private Operator operator;
    private ParkingSlot parkingSlot; // this has floor and lot detail
    private Gate gate;
    private LocalDateTime entryTime;
}
