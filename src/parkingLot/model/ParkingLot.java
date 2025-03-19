package src.parkingLot.model;

import lombok.Getter;
import lombok.Setter;
import src.parkingLot.factory.ParkingStrategyFactory;

import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Operator> operators;
    private List<Gate> gates;
    private Status status;
//    private ParkingStrategyFactory parkingStrategyFactory;

//    public ParkingLot() {
//        parkingStrategyFactory = new ParkingStrategyFactory();
//    }
}
