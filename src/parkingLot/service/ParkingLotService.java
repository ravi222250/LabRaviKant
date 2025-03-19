package src.parkingLot.service;

import src.parkingLot.Exception.ParkingLotNotFoundException;
import src.parkingLot.factory.ParkingStrategyFactory;
import src.parkingLot.model.ParkingLot;
import src.parkingLot.model.ParkingSlot;
import src.parkingLot.model.VehicleType;
import src.parkingLot.repository.ParkingLotRepository;
import src.parkingLot.strategy.ParkingStrategy;
import src.parkingLot.strategy.ParkingStrategyType;

import java.util.Optional;

public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

    public ParkingLot getParkingLotById (Integer parkingLotId) throws ParkingLotNotFoundException {
        return parkingLotRepository.findParkingLotById(parkingLotId)
                .orElseThrow(() -> new ParkingLotNotFoundException("Parking lot was not found"));
    }

    public Optional<ParkingSlot> findAvailableParkingLot(
            ParkingStrategyType parkingStrategyType,
            ParkingLot parkingLot,
            VehicleType vehicleType) {
        ParkingStrategy parkingStrategy = ParkingStrategyFactory.getParkingStrategy(parkingStrategyType);
        return parkingStrategy.findParkingSlot(parkingLot, vehicleType);
    }

}
