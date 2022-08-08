package com.holdencasey;

/**
 * A special TimePeriod that includes a contribution amount for each subdivision of time.
 */
class Contribution extends TimePeriod{
    final float[] contributionAmounts; //an array of contribution amounts in dollars

    /**
     * Main constructor.
     *
     * @param contributionAmounts an array of contribution amounts in dollars.
     * @param numPeriods the number of unique time periods.
     * @param periodLengths an array of period lengths, in years.
     * @param totalPeriod the total time period.
     */
    Contribution(float[] contributionAmounts, int numPeriods, int[] periodLengths, int totalPeriod) {
        super(numPeriods, periodLengths, totalPeriod);
        this.contributionAmounts = contributionAmounts;
    }

    /**
     * Constructor if TimePeriod is already created.
     *
     * @param contributionAmounts an array of contribution amounts in dollars.
     * @param timePeriod the existing TimePeriod object
     */
    Contribution(float[] contributionAmounts, TimePeriod timePeriod) {
        super(timePeriod);
        this.contributionAmounts = contributionAmounts;
    }

    /**
     * Constructor with only one contribution amount, and a time period int.
     *
     * @param contributionAmount the single contribution amount.
     * @param timePeriod the single time period as an int.
     */
    Contribution(float contributionAmount, int timePeriod) {
        this(new float[]{contributionAmount}, new TimePeriod(timePeriod));
    }
}
