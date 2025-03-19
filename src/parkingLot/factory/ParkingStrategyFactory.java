package src.parkingLot.factory;

import src.parkingLot.strategy.ParkingStrategy;
import src.parkingLot.strategy.ParkingStrategyType;
import src.parkingLot.strategy.RandomParkingStrategy;

public class ParkingStrategyFactory {

    public static ParkingStrategy getParkingStrategy (ParkingStrategyType parkingStrategyType) {
        if (parkingStrategyType == ParkingStrategyType.RANDOM) {
            return new RandomParkingStrategy();
        }
        return null;
    }
}
