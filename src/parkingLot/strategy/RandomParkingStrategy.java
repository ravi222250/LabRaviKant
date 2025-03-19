package src.parkingLot.strategy;

import src.parkingLot.model.ParkingLot;
import src.parkingLot.model.ParkingSlot;
import src.parkingLot.model.Status;
import src.parkingLot.model.VehicleType;

import java.util.Optional;

public class RandomParkingStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingSlot> findParkingSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        return parkingLot.getParkingFloors().stream()
                .filter(parkingFloor -> parkingFloor.getStatus() == Status.Available)
                .flatMap(parkingFloor -> parkingFloor.getParkingSlots().stream())
                .filter(parkingSlot -> parkingSlot.getStatus() == Status.Available)
                .filter(parkingSlot -> parkingSlot.getSupportedVehicleTypes().contains(vehicleType))
                .findFirst();
    }
}
