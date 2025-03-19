package src.parkingLot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingSlot extends BaseModel {
    private int slotNumber;
    private List<VehicleType> supportedVehicleTypes;
    private Status status;
    private Integer parkingFloorId;
    private Vehicle vehicle;
}
