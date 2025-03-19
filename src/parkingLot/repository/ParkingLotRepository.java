package src.parkingLot.repository;

import src.parkingLot.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ParkingLotRepository {

    List<ParkingLot> parkingLots;

    public ParkingLotRepository () {
        parkingLots = new ArrayList<>();

        ArrayList<ParkingSlot> parkingSlots = new ArrayList<>();
        ParkingSlot parkingSlot1 = new ParkingSlot();
        parkingSlot1.setId(1);
        parkingSlot1.setParkingFloorId(1);
        parkingSlot1.setSlotNumber(1);
        parkingSlot1.setStatus(Status.Filled);
        parkingSlot1.setVehicle(new Vehicle()); //dummy vehicle object
        parkingSlot1.setSupportedVehicleTypes(List.of(VehicleType.FOUR_WHEELER, VehicleType.TWO_WHEELER));
        parkingSlots.add(parkingSlot1);

        ArrayList<ParkingFloor> parkingFloors = new ArrayList<>();
        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.setId(1);
        parkingFloor1.setParkingLotId(1);
        parkingFloor1.setStatus(Status.Available);
        parkingFloor1.setParkingSlots(parkingSlots);
        parkingFloors.add(parkingFloor1);

        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.setId(1);
        parkingLot1.setParkingFloors(parkingFloors);
        parkingLot1.setStatus(Status.Available);

        parkingLots.add(parkingLot1);
    }

    public Optional<ParkingLot> findParkingLotById(Integer parkingLotId) {
        return parkingLots.stream()
                .filter(parkingLot -> Objects.equals(parkingLot.getId(), parkingLotId))
                .findFirst();
    }

}
