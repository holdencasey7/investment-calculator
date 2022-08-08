package com.holdencasey;

/**
 * Combines ReturnRate and Contribution, along with a starting value and a total time period.
 */
class Profile {
    final float startingValue; //The starting amount in dollars
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
    Profile(float startingValue, Contribution contributionSystem, ReturnRate returnRate, int totalTimePeriod) {
        this.startingValue = startingValue;
        this.contributionSystem = contributionSystem;
        this.returnRate = returnRate;
        this.totalTimePeriod = totalTimePeriod;
    }

    /**
     * No starting value constructor. Defaults to 0 starting.
     *
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     * @param totalTimePeriod the total time period.
     */
    Profile(Contribution contributionSystem, ReturnRate returnRate, int totalTimePeriod) {
        this(0f, contributionSystem, returnRate, totalTimePeriod);
    }
}
