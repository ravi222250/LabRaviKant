package src.parkingLot.Exception;

public class ParkingLotNotFoundException extends Exception {

    private String message;

    public ParkingLotNotFoundException(String message) {
        this.message = message;
    }
}
