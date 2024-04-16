package ee.taltech.inbankbackend.exceptions;

public class InvalidInputException extends Throwable {
    private final String message;
    private final Throwable cause;

    public InvalidInputException(String message) {
        this(message, null);
    }

    public InvalidInputException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
