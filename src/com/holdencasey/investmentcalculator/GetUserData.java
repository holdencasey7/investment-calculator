package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
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

    static int getTimePeriod(Scanner scanner) {
        System.out.println("Enter the total investment period: ");
        return scanner.nextInt();
    }

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

        //>1 time period
        System.out.println("Reminder: you chose a " + timeperiod + " year total time length.");
        int[] periodLengths = new int[numPeriods];
        int totalPeriods = 0;
        for (int i = 0; i < numPeriods; i++) {
            System.out.println("Enter the length for Period " + (i + 1) + ": ");
            periodLengths[i] = scanner.nextInt();
            totalPeriods += periodLengths[i];
            //Check that period lengths are not longer than total investment length
            if (totalPeriods > timeperiod) {
                System.out.println("Contribution periods cannot be longer than total investment length.");
                totalPeriods -= periodLengths[i--];
                //This ...should... work
            }
        }
    }
}
