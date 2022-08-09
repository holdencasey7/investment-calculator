package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class GetUserData {

    //TODO: add JavaDocs
    static MoneyStory createMoneyStory() {
        Scanner getValues = new Scanner(System.in);

        //Get starting value
        BigDecimal startingValue = getStartingValue(getValues);

        //Get total time period
        int totalTimePeriod = getTimePeriod(getValues);

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
            System.out.println("Enter the yearly contribution amount: ");
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
}
