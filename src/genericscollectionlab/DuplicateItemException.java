package src.genericscollectionlab;

public class DuplicateItemException extends RuntimeException {

    private final int errorCode;
    private String message;

    public DuplicateItemException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
