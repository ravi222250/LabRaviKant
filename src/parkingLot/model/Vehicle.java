package src.parkingLot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vehicle extends BaseModel {
    private VehicleType vehicleType;
    private String licensePlate;
    private String ownerName;
}
