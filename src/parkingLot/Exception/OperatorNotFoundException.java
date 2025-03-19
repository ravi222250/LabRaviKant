package src.parkingLot.Exception;

public class OperatorNotFoundException extends Exception {

    private String message;

    public OperatorNotFoundException(String message) {
        this.message = message;
    }
}
