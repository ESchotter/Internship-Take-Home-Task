package ee.taltech.inbankbackend.component;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class PersonalCodeDecoder {

    /**
     * Calculates age of the customer in full years according to their ID code.
     *
     * @param personalCode ID code of the customer that made the request.
     * @return Age of the customer.
     */
    public Integer calculateAgeFromPersonalCode(String personalCode) {
        int centuryOfBirth = 0;
        
        if (Integer.parseInt(personalCode.substring(0, 1)) >= 1
                && Integer.parseInt(personalCode.substring(0, 1)) <= 2) {
            centuryOfBirth = 19;
        } else if (Integer.parseInt(personalCode.substring(0, 1)) >= 3
                && Integer.parseInt(personalCode.substring(0, 1)) <= 4) {
            centuryOfBirth = 20;
        } else if (Integer.parseInt(personalCode.substring(0, 1)) >= 5
                && Integer.parseInt(personalCode.substring(0, 1)) <= 6) {
            centuryOfBirth = 21;
        } else if (Integer.parseInt(personalCode.substring(0, 1)) >= 7
                && Integer.parseInt(personalCode.substring(0, 1)) <= 8) {
            centuryOfBirth = 22;
        }

        int yearOfBirth = (centuryOfBirth - 1) * 100 + Integer.parseInt(personalCode.substring(1, 3));

        LocalDate birthDate = LocalDate.of(
                yearOfBirth,
                Integer.parseInt(personalCode.substring(3, 5)),
                Integer.parseInt(personalCode.substring(5, 7))
        );

        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    /**
     * Mock up finding the country code of the customer according to the last two digits of their ID code.
     * EST - 00...33
     * LVA - 34...66
     * LTU - 67...99
     *
     * @param personalCode ID code of the customer that made the request.
     * @return Country code in ISO 3166-1 alpha-3 standard of country to which the customer belongs.
     */
    public String findCountryCodeByPersonalCode(String personalCode) {
        int suffix = Integer.parseInt(personalCode.substring(personalCode.length() - 2));

        if (suffix < 33) {
            return "EST";
        } else if (suffix < 66) {
            return "LVA";
        }

        return "LTU";
    }
}
