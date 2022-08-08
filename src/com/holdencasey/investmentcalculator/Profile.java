package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * Combines ReturnRate and Contribution, along with a starting value and a total time period.
 */
class Profile {
    private final static BigDecimal DEFAULT_STARTING_VALUE = new BigDecimal(0); //Default starting value if none provided

    final BigDecimal startingValue; //The starting amount in dollars
    final Contribution contributionSystem; //The Contribution system object
    final ReturnRate returnRate; //The ReturnRate system object
    final int totalTimePeriod; //The total time period.

    /**
     * Main constructor.
     *
     * @param startingValue the initial investment value.
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     * @param totalTimePeriod the total time period.
     */
    Profile(BigDecimal startingValue, Contribution contributionSystem, ReturnRate returnRate, int totalTimePeriod) {
        this.startingValue = startingValue.setScale(2, RoundingMode.HALF_UP);;
        this.contributionSystem = contributionSystem;
        this.returnRate = returnRate;
        this.totalTimePeriod = totalTimePeriod;
    }

    /**
     * No total time period constructor. Defaults to length of return period.
     *
     * @param startingValue the initial investment value.
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     */
    Profile(BigDecimal startingValue, Contribution contributionSystem, ReturnRate returnRate) {
        this(startingValue, contributionSystem, returnRate, returnRate.totalPeriod);
    }

    /**
     * Only Contribution and ReturnRate constructor. Uses default for starting and return period length.
     *
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     */
    Profile(Contribution contributionSystem, ReturnRate returnRate) {
        this(contributionSystem, returnRate, returnRate.totalPeriod);
    }

    /**
     * No starting value constructor. Defaults to 0 starting.
     *
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     * @param totalTimePeriod the total time period.
     */
    Profile(Contribution contributionSystem, ReturnRate returnRate, int totalTimePeriod) {
        this(DEFAULT_STARTING_VALUE, contributionSystem, returnRate, totalTimePeriod);
    }

    @Override
    public String toString() {
        return "Starting Value: $" + this.startingValue + " | " +
                "Total length: " + this.totalTimePeriod + " years | Unique Returns: " +
                Arrays.toString(this.returnRate.ratesOfReturn) + " | Unique Contributions: " +
                Arrays.toString(this.contributionSystem.contributionAmounts);
    }
}
