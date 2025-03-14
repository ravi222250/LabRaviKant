package src.genericscollectionlab;

public class ItemNotFoundException extends RuntimeException {

    private final int errorCode;
    private String message;

    public ItemNotFoundException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
