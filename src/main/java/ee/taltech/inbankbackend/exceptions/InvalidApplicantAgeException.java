package ee.taltech.inbankbackend.exceptions;

/**
 * Thrown when applicant age is invalid.
 */
public class InvalidApplicantAgeException extends  InvalidInputException{

    public InvalidApplicantAgeException(String message) {
        super(message);
    }

}
