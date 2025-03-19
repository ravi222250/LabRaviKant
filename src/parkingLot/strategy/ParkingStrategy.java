package src.parkingLot.strategy;

import src.parkingLot.model.ParkingLot;
import src.parkingLot.model.ParkingSlot;
import src.parkingLot.model.VehicleType;

import javax.swing.plaf.OptionPaneUI;
import java.util.Optional;

public interface ParkingStrategy {

    public Optional<ParkingSlot> findParkingSlot(ParkingLot parkingLot, VehicleType vehicleType);

}
