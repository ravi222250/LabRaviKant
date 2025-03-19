package src.parkingLot.service;

import src.parkingLot.model.Vehicle;
import src.parkingLot.model.VehicleType;
import src.parkingLot.repository.VehicleRepository;

import java.util.Optional;

public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private static Integer IDCounter = 0;

    public VehicleService (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Optional<Vehicle> findVehicleByLicensePlate (String licensePlate) {
        return vehicleRepository.getVehicleByLicensePlate(licensePlate);
    }

    public Vehicle save (String ownerName, String licensePlate, VehicleType vehicleType) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleType);
        vehicle.setOwnerName(ownerName);
        vehicle.setLicensePlate(licensePlate);
        vehicle.setId(IDCounter++);
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
