package src.parkingLot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel{
    private Integer parkingLotId;
    private List<ParkingSlot> parkingSlots;
    private Status status;

}
