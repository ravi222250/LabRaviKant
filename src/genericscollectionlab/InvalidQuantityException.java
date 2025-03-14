package src.genericscollectionlab;

public class InvalidQuantityException extends Exception {

    private final int errorCode;
    private String mesage;

    public InvalidQuantityException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
