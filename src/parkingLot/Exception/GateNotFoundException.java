package src.parkingLot.Exception;

public class GateNotFoundException extends Exception {

    private String message;

    public GateNotFoundException(String message) {
        this.message = message;
    }
}
