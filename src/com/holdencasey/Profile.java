package com.holdencasey;

/**
 * Combines ReturnRate and Contribution, along with a starting value, into a story of money.
 */
class Profile {
    private float startingValue; //The starting amount in dollars
    private Contribution contributionSystem; //The Contribution system object
    private ReturnRate returnRate; //The ReturnRate system object
    private float endingValue; //The ending value. Must be calculated.

    /**
     * Main constructor.
     *
     * @param startingValue the initial investment value.
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     */
    Profile(float startingValue, Contribution contributionSystem, ReturnRate returnRate) {
        this.startingValue = startingValue;
        this.contributionSystem = contributionSystem;
        this.returnRate = returnRate;

        this.endingValue = 0f; //Placeholder
    }

    /**
     * No starting value constructor. Defaults to 0 starting.
     *
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     */
    Profile(Contribution contributionSystem, ReturnRate returnRate) {
        this(0f, contributionSystem, returnRate);
    }


}
