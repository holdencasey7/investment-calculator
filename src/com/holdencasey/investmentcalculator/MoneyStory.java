package com.holdencasey.investmentcalculator;

import java.util.ArrayList;

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
        return years[years.length - 1].endValue;
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

    /**
     * Creates a yearly contribution ArrayList.
     *
     * @return a float ArrayList with each element being a contribution for one year.
     */
    ArrayList<Float> makeContributionArray() {
        ArrayList<Float> totalContributions = new ArrayList<>(investmentProfile.totalTimePeriod);
        for (int i = 0; i < investmentProfile.contributionSystem.numPeriods; i++) {
            for (int j = 0; j < investmentProfile.contributionSystem.periodLengths[i]; j++) {
                totalContributions.add(investmentProfile.contributionSystem.contributionAmounts[i]);
            }
        }
        return totalContributions;
    }
}
