package ee.taltech.inbankbackend.exceptions;

/**
 * Thrown when applicant age is invalid.
 */
public class InvalidApplicantAgeException extends  Throwable{
    private final String message;
    private final Throwable cause;

    public InvalidApplicantAgeException(String message) {
        this(message, null);
    }

    public InvalidApplicantAgeException(String message, Throwable cause) {
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
