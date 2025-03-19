package src.parkingLot.repository;

import src.parkingLot.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleRepository {

    private List<Vehicle> vehicles;

    public VehicleRepository () {
        vehicles = new ArrayList<>();
    }

    public Optional<Vehicle> getVehicleByLicensePlate(String licensePlate) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getLicensePlate().equalsIgnoreCase(licensePlate))
                .findFirst();
    }

    public void save (Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
