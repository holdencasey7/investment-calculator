package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class GetUserData {

    /**
     * Calls multiple methods to obtain all user data required for a new MoneyStory.
     *
     * @param getValues the Scanner object used to get data.
     * @return a new MoneyStory based on user-inputted data.
     */
    static MoneyStory createMoneyStory(Scanner getValues) {
        //Get starting value
        BigDecimal startingValue = getStartingValue(getValues);

        //Get total time period
        int totalTimePeriod = getTimePeriod(getValues);

        //Get Contribution data
        Contribution contribution = createContribution(getValues, totalTimePeriod);

        //Get ReturnRate data
        ReturnRate returnRate = createReturnRate(getValues, totalTimePeriod);

        //Create Profile
        Profile profile = new Profile(startingValue, contribution, returnRate, totalTimePeriod);

        return new MoneyStory(profile);
    }

    /**
     * Obtains a starting value from the user.
     *
     * @param scanner the Scanner object used to get data.
     * @return a BigDecimal containing the starting value.
     */
    static BigDecimal getStartingValue(Scanner scanner) {
        System.out.println("Enter starting value: ");
        return scanner.nextBigDecimal();
    }

    /**
     * Obtains a total investment time period from the user.
     *
     * @param scanner the Scanner object used to get data.
     * @return an int containing the total time period.
     */
    static int getTimePeriod(Scanner scanner) {
        System.out.println("Enter the total investment period: ");
        return scanner.nextInt();
    }

    /**
     * Obtains contribution system data from the user.
     *
     * @param scanner the Scanner object used to get data.
     * @param timeperiod the total time period. Used to check against contribution time periods.
     * @return a Contribution object using user data.
     */
    static Contribution createContribution(Scanner scanner, int timeperiod) {
        System.out.println("How many unique contribution periods?\n" +
                "A unique contribution period is a period with a standard yearly contribution amount.\n" +
                "Include periods with 0 contributions or negative contributions (withdraw).\n" +
                "Enter unique contribution periods: ");
        int numPeriods = scanner.nextInt();

        //Only one period
        if (numPeriods == 1) {
            System.out.print("\nEnter the yearly contribution amount: ");
            BigDecimal contributionAmount = scanner.nextBigDecimal();
            return new Contribution(contributionAmount, timeperiod);
        }

        /* >1 period */
        //Get contribution amounts
        BigDecimal[] contributionAmounts = new BigDecimal[numPeriods];
        for (int i = 0; i < numPeriods; i++) {
            System.out.print("\nEnter the contribution amount for Period " + (i + 1) + ": $");
            BigDecimal currContribution = scanner.nextBigDecimal();
            contributionAmounts[i] = currContribution.setScale(2, RoundingMode.HALF_UP);
        }

        //Get period lengths
        System.out.println("\nReminder: you chose a " + timeperiod + " year total time length.");
        int[] periodLengths = new int[numPeriods];
        int totalPeriods = 0;
        for (int i = 0; i < numPeriods; i++) {
            System.out.print("\nEnter the length for Period " + (i + 1) +
                    " with contribution $" + contributionAmounts[i] + ": ");
            periodLengths[i] = scanner.nextInt();
            totalPeriods += periodLengths[i];
            //Check that period lengths are not longer than total investment length
            if (totalPeriods > timeperiod) {
                System.out.println("\nContribution periods cannot be longer than total investment length.");
                totalPeriods -= periodLengths[i--];
                //This ...should... work
            }
        }

        return new Contribution(contributionAmounts, periodLengths);
    }

    /**
     * Obtains returns data from user.
     *
     * @param scanner the Scanner object used to get data.
     * @param timeperiod the total time period. Used to check against contribution time periods.
     * @return a ReturnRate object using user data.
     */
    static ReturnRate createReturnRate(Scanner scanner, int timeperiod) {
        System.out.print("\nHow many unique return periods?\n" +
                "A unique return period is a period with a standard yearly rate of return.\n" +
                "Include periods with 0% return.\n" +
                "Enter unique return periods: ");
        int numPeriods = scanner.nextInt();

        //Only one period
        if (numPeriods == 1) {
            System.out.print("\nEnter the yearly rate of return: ");
            BigDecimal rateOfReturn = scanner.nextBigDecimal();
            return new ReturnRate(rateOfReturn, timeperiod);
        }

        /* >1 period */
        //Get return rates
        BigDecimal[] returnRates = new BigDecimal[numPeriods];
        for (int i = 0; i < numPeriods; i++) {
            System.out.print("\nEnter the rate of return for Period " + (i + 1) + ": %");
            BigDecimal currContribution = scanner.nextBigDecimal();
            returnRates[i] = currContribution.setScale(2, RoundingMode.HALF_UP);
        }

        //Get period lengths
        System.out.println("\nReminder: you chose a " + timeperiod + " year total time length.");
        int[] periodLengths = new int[numPeriods];
        int totalPeriods = 0;
        for (int i = 0; i < numPeriods; i++) {
            System.out.print("\nEnter the length for Period " + (i + 1) +
                    " with return rate " + returnRates[i] + "%: ");
            periodLengths[i] = scanner.nextInt();
            totalPeriods += periodLengths[i];
            //Check that period lengths are not longer than total investment length
            if (totalPeriods > timeperiod) {
                System.out.println("\nReturn periods cannot be longer than total investment length.");
                totalPeriods -= periodLengths[i--];
                //This ...should... work
            }
        }

        return new ReturnRate(returnRates, periodLengths);
    }
}
