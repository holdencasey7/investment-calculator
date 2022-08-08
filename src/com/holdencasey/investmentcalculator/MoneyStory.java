package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * The final value and story of the money values.
 */
class MoneyStory {
    final Profile investmentProfile; //the investment profile
    Year[] years;

    /**
     * Main constructor.
     *
     * @param investmentProfile the investment profile.
     */
    MoneyStory(Profile investmentProfile) {
        this.investmentProfile = investmentProfile;
        this.years = this.makeYearArray();
    }

    /**
     * Calculates total investment value after all contributions and returns.
     *
     * @return the final investment value, in dollars.
     */
    BigDecimal calculateEndValue() {
        return years[years.length - 1].endValue;
    }

    /**
     * Static method that calls instance method using new object created from passed Profile.
     *
     * @param investmentProfile the Profile to use.
     * @return the final investment value, in dollars.
     */
    static BigDecimal calculateEndValue(Profile investmentProfile) {
        return (new MoneyStory(investmentProfile)).calculateEndValue();
    }

    /**
     * Creates a yearly contribution ArrayList.
     *
     * @return a BigDecimal ArrayList with each element being a contribution for one year.
     */
    ArrayList<BigDecimal> makeContributionArray() {
        ArrayList<BigDecimal> totalContributions = new ArrayList<>(investmentProfile.totalTimePeriod);
        for (int i = 0; i < investmentProfile.contributionSystem.numPeriods; i++) {
            for (int j = 0; j < investmentProfile.contributionSystem.periodLengths[i]; j++) {
                totalContributions.add(investmentProfile.contributionSystem.contributionAmounts[i]);
            }
        }
        return totalContributions;
    }

    /**
     * Creates a yearly return rate ArrayList.
     *
     * @return a BigDecimal ArrayList with each element being a return rate for one year.
     */
    ArrayList<BigDecimal> makeReturnArray() {
        ArrayList<BigDecimal> totalReturns = new ArrayList<>(investmentProfile.totalTimePeriod);
        for (int i = 0; i < investmentProfile.returnRate.numPeriods; i++) {
            for (int j = 0; j < investmentProfile.returnRate.periodLengths[i]; j++) {
                totalReturns.add(investmentProfile.returnRate.ratesOfReturn[i]);
            }
        }
        return totalReturns;
    }

    /**
     * Creates an array of Years documenting the change in money value.
     *
     * @return the Year array for this MoneyStory.
     */
    Year[] makeYearArray() {
        Year[] yearArray = new Year[investmentProfile.totalTimePeriod];
        ArrayList<BigDecimal> contributions = this.makeContributionArray();
        ArrayList<BigDecimal> returns = this.makeReturnArray();

        /* First year uses original start value */
        yearArray[0] = new Year(investmentProfile.startingValue, contributions.get(0), returns.get(0));

        /* Each subsequent year passed previous year for new value */
        for (int i = 1; i < investmentProfile.totalTimePeriod; i++) {
            yearArray[i] = new Year(yearArray[i - 1], contributions.get(i), returns.get(i));
        }

        return yearArray;
    }

    BigDecimal calculateTotalContributions() {
        //Return sum of total contributions
        //THIS IS WHERE I WAS
        return null;
    }

    /**
     * Prints each year of the MoneyStory.
     */
    void printYears() {
        for (int i = 0; i < this.years.length; i++) {
            System.out.println("Year " + (i + 1) + ": " + years[i]);
        }
    }

    /**
     * Prints the starting value, ending value, and time period.
     */
    void printStartAndEnd() {
        System.out.printf("After %d years, $%.2f became $%.2f.", this.investmentProfile.totalTimePeriod,
                this.investmentProfile.startingValue, this.calculateEndValue());
    }

    /**
     * Prints the starting value, ending value, time period, and total contributions made.
     */
    void printStartAndEndWithContributions() {
        System.out.printf("After %d years, $%.2f became $%.2f with %.2f in total contributions",
                this.investmentProfile.totalTimePeriod, this.investmentProfile.startingValue,
                this.calculateEndValue(), this.calculateTotalContributions());
    }

    @Override
    public String toString() {
        return investmentProfile.toString() + " | Ending Value: $" +
                this.calculateEndValue();
    }
}
