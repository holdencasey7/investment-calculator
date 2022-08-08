package com.holdencasey.investmentcalculator;

/**
 * Represents a single year of changes to money value.
 */
public class Year {
    private final static float DEFAULT_STARTING_VALUE = 0f; //Default starting value if none provided

    float startValue; //Value at start of year
    float endValue; //Value at end of year after contribution and return
    float contribution; //Contribution made at start of year
    float returnRate; //Return rate earned for the 1-year period

    /**
     * Main constructor. Calculates end value.
     *
     * @param startValue the value at the start of the year.
     * @param contribution the contribution made at the start of the year.
     * @param returnRate the return rate earned for the 1-year period.
     */
    Year(float startValue, float contribution, float returnRate) {
        this.startValue = startValue;
        this.contribution = contribution;
        this.returnRate = returnRate;
        this.endValue = (startValue + contribution) * (1 + (returnRate / 100f));
    }

    /**
     * No starting value constructor. Defaults to 0f.
     *
     * @param contribution the contribution made at the start of the year.
     * @param returnRate the return rate earned for the 1-year period.
     */
    Year(float contribution, float returnRate) {
        this(DEFAULT_STARTING_VALUE, contribution, returnRate);
    }

    /**
     * Constructs a year based on the ending value of a prior year.
     *
     * @param priorYear the prior year to use.
     * @param newContribution the contribution made at the start of the new year.
     * @param newReturnRate the return rate earned for the new 1-year period.
     */
    Year(Year priorYear, float newContribution, float newReturnRate) {
        this(priorYear.endValue, newContribution, newReturnRate);
    }
}
