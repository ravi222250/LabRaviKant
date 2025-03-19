package src.parkingLot.dto;

import lombok.Getter;
import lombok.Setter;
import src.parkingLot.model.Operator;
import src.parkingLot.model.VehicleType;
import src.parkingLot.strategy.ParkingStrategyType;

@Getter
@Setter
public class TicketRequestDto {

    private String ownerName;
    private VehicleType vehicleType;
    private String licensePlate;
    private int gateid;
    private Integer operatorId;
    private Integer parkingLotId;
    private ParkingStrategyType parkingStrategyType;

}
