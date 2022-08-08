package com.holdencasey;

/**
 * The final value and story of the money values.
 */
public class MoneyStory {
    final Profile investmentProfile; //the investment profile
    Year[] years;

    /**
     * Main constructor.
     *
     * @param investmentProfile the investment profile.
     */
    MoneyStory(Profile investmentProfile) {
        this.investmentProfile = investmentProfile;
        this.years = new Year[investmentProfile.totalTimePeriod];
    }

    /**
     * Calculates total investment value after all contributions and returns.
     *
     * @return the final investment value, in dollars.
     */
    float calculateEndValue() {
        return 0f; //Placeholder
    }

    /**
     * Static method that calls instance method using new object created from passed Profile.
     *
     * @param investmentProfile the Profile to use.
     * @return the final investment value, in dollars.
     */
    static float calculateEndValue(Profile investmentProfile) {
        return (new MoneyStory(investmentProfile)).calculateEndValue();
    }
}
