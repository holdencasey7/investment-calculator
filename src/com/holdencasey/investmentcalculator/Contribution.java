package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * A special TimePeriod that includes a contribution amount for each subdivision of time.
 */
class Contribution extends TimePeriod{
    final BigDecimal[] contributionAmounts; //an array of contribution amounts in dollars

    /**
     * Main constructor.
     *
     * @param contributionAmounts an array of contribution amounts in dollars.
     * @param numPeriods the number of unique time periods.
     * @param periodLengths an array of period lengths, in years.
     * @param totalPeriod the total time period.
     */
    Contribution(BigDecimal[] contributionAmounts, int numPeriods, int[] periodLengths, int totalPeriod) {
        super(numPeriods, periodLengths, totalPeriod);
        this.contributionAmounts = contributionAmounts;
    }

    /**
     * Constructor if TimePeriod is already created.
     *
     * @param contributionAmounts an array of contribution amounts in dollars.
     * @param timePeriod the existing TimePeriod object
     */
    Contribution(BigDecimal[] contributionAmounts, TimePeriod timePeriod) {
        super(timePeriod);
        this.contributionAmounts = contributionAmounts;
    }

    /**
     * Constructor with only one contribution amount, and a time period int.
     *
     * @param contributionAmount the single contribution amount.
     * @param timePeriod the single time period as an int.
     */
    Contribution(BigDecimal contributionAmount, int timePeriod) {
        this(new BigDecimal[]{contributionAmount}, new TimePeriod(timePeriod));
    }

    @Override
    public String toString() {
        return super.toString() + " | Contributions: " +
                Arrays.toString(this.contributionAmounts);
    }
}
