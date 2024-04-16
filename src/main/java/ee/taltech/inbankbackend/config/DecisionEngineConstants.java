package ee.taltech.inbankbackend.config;

import java.util.Map;

/**
 * Holds all necessary constants for the decision engine.
 */
public class DecisionEngineConstants {
    public static final Integer MINIMUM_LOAN_AMOUNT = 2000;
    public static final Integer MAXIMUM_LOAN_AMOUNT = 10000;
    public static final Integer MAXIMUM_LOAN_PERIOD = 60;
    public static final Integer MINIMUM_LOAN_PERIOD = 12;
    public static final Integer MINIMUM_APPLICANT_AGE = 18;
    public static final Map<String, Integer> LIFE_EXPECTANCY = Map.ofEntries(
            Map.entry("EST", 78),
            Map.entry("LVA", 74),
            Map.entry("LTU", 76)
    );
    public static final Integer SEGMENT_1_CREDIT_MODIFIER = 100;
    public static final Integer SEGMENT_2_CREDIT_MODIFIER = 300;
    public static final Integer SEGMENT_3_CREDIT_MODIFIER = 1000;
}
