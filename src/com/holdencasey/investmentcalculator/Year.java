package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a single year of changes to money value.
 */
class Year {
    private final static BigDecimal DEFAULT_STARTING_VALUE = new BigDecimal(0); //Default starting value if none provided

    BigDecimal startValue; //Value at start of year
    BigDecimal endValue; //Value at end of year after contribution and return
    BigDecimal contribution; //Contribution made at start of year
    BigDecimal returnRate; //Return rate earned for the 1-year period

    /**
     * Main constructor. Calculates end value.
     *
     * @param startValue the value at the start of the year.
     * @param contribution the contribution made at the start of the year.
     * @param returnRate the return rate earned for the 1-year period.
     */
    Year(BigDecimal startValue, BigDecimal contribution, BigDecimal returnRate) {
        this.startValue = startValue.setScale(2, RoundingMode.HALF_UP);
        this.contribution = contribution.setScale(2, RoundingMode.HALF_UP);
        this.returnRate = returnRate.setScale(2, RoundingMode.HALF_UP);
        //This is where the magic happens
        this.endValue = startValue
                .add(contribution)
                .multiply((new BigDecimal(1)
                        .add(returnRate
                                .divide(new BigDecimal(100)))))
                .setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * No starting value constructor. Defaults to 0.
     *
     * @param contribution the contribution made at the start of the year.
     * @param returnRate the return rate earned for the 1-year period.
     */
    Year(BigDecimal contribution, BigDecimal returnRate) {
        this(DEFAULT_STARTING_VALUE, contribution, returnRate);
    }

    /**
     * Constructs a year based on the ending value of a prior year.
     *
     * @param priorYear the prior year to use.
     * @param newContribution the contribution made at the start of the new year.
     * @param newReturnRate the return rate earned for the new 1-year period.
     */
    Year(Year priorYear, BigDecimal newContribution, BigDecimal newReturnRate) {
        this(priorYear.endValue, newContribution, newReturnRate);
    }

    @Override
    public String toString() {
        return "Start Value: $" + this.startValue +
                " | End Value: $" + this.endValue +
                " | Contribution: $" + this.contribution +
                " | Return: " + this.returnRate + "%";
    }
}
