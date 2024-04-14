package ee.taltech.inbankbackend.component;

import com.github.vladislavgoltjajev.personalcode.locale.estonia.EstonianPersonalCodeValidator;
import ee.taltech.inbankbackend.config.DecisionEngineConstants;
import ee.taltech.inbankbackend.exceptions.InvalidLoanAmountException;
import ee.taltech.inbankbackend.exceptions.InvalidLoanPeriodException;
import ee.taltech.inbankbackend.exceptions.InvalidPersonalCodeException;
import org.springframework.stereotype.Component;

@Component
public class LoanInputValidator {

    private final EstonianPersonalCodeValidator validator  = new EstonianPersonalCodeValidator();

    /**
     * Validates that all inputs are valid according to business rules.
     * If inputs are invalid, then throws corresponding exceptions.
     *
     * @param personalCode Provided personal ID code
     * @param loanAmount Requested loan amount
     * @param loanPeriod Requested loan period
     * @throws InvalidPersonalCodeException If the provided personal ID code is invalid
     * @throws InvalidLoanAmountException If the requested loan amount is invalid
     * @throws InvalidLoanPeriodException If the requested loan period is invalid
     */
    public void validateInput(String personalCode, Long loanAmount, int loanPeriod)
            throws InvalidPersonalCodeException, InvalidLoanAmountException, InvalidLoanPeriodException {
        validatePersonalCode(personalCode);
        validateLoanAmount(loanAmount);
        validateLoanPeriod(loanPeriod);
    }

    /**
     * Validates that personal code in the input is valid.
     * If personal code is invalid, then throws corresponding exception
     *
     * @param personalCode The personal code to validate.
     * @throws InvalidPersonalCodeException If the personal code is invalid.
     */
    private void validatePersonalCode(String personalCode) throws InvalidPersonalCodeException {
        if (!validator.isValid(personalCode)) {
            throw new InvalidPersonalCodeException("Invalid personal ID code!");
        }
    }

    /**
     * Validates that loan amount in the input is valid.
     * If loan amount is invalid, then throws corresponding exception
     *
     * @param loanAmount The requested loan amount.
     * @throws InvalidLoanAmountException If the loan amount is invalid.
     */
    private void validateLoanAmount(Long loanAmount) throws InvalidLoanAmountException {
        if (loanAmount == null
                || loanAmount < DecisionEngineConstants.MINIMUM_LOAN_AMOUNT
                || loanAmount > DecisionEngineConstants.MAXIMUM_LOAN_AMOUNT) {
            throw new InvalidLoanAmountException("Invalid loan amount!");
        }
    }

    /**
     * Validates that loan period in the input is valid.
     * If loan period is invalid, then throws corresponding exception
     *
     * @param loanPeriod The requested loan amount.
     * @throws InvalidLoanPeriodException If the loan period is invalid.
     */
    private void validateLoanPeriod(int loanPeriod) throws InvalidLoanPeriodException {
        if (loanPeriod < DecisionEngineConstants.MINIMUM_LOAN_PERIOD
                || loanPeriod > DecisionEngineConstants.MAXIMUM_LOAN_PERIOD) {
            throw new InvalidLoanPeriodException("Invalid loan period!");
        }
    }

}
