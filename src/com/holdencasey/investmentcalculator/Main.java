package com.holdencasey.investmentcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner terminalInput = new Scanner(System.in);
        MoneyStory newMoneyStory = GetUserData.createMoneyStory(terminalInput);
        newMoneyStory.printStartAndEndWithContributions();

        /* New more realistic test
        int[] contLengths = {5, 40, 20};
        BigDecimal[] contributions = {
                new BigDecimal(500),
                new BigDecimal(6000),
                new BigDecimal(-10000)
        };
        Contribution testContribution = new Contribution(contributions, contLengths);

        int[] returnLengths = {45, 20};
        BigDecimal[] returns = {
                new BigDecimal(9.5),
                new BigDecimal(5.5)
        };
        ReturnRate testReturnRate = new ReturnRate(returns, returnLengths);

        MoneyStory testMoneyStory = new MoneyStory(new Profile(testContribution, testReturnRate));

        testMoneyStory.printStartAndEndWithContributions(); */

        /* Old Test
        int[] lengths = {4, 2, 1, 3};
        TimePeriod testTimePeriod = new TimePeriod(lengths);

        BigDecimal[] contributions = {new BigDecimal(10.5), new BigDecimal(3),
                new BigDecimal(9), new BigDecimal(11.3).setScale(2, RoundingMode.HALF_UP)};
        Contribution testContribution = new Contribution(contributions, testTimePeriod);

        BigDecimal[] returns = {new BigDecimal(8), new BigDecimal(6.5),
                new BigDecimal(14), new BigDecimal(6)};
        ReturnRate testReturnRate = new ReturnRate(returns, testTimePeriod);

        Profile testProfile = new Profile(testContribution, testReturnRate);

        MoneyStory testMoneyStory = new MoneyStory(testProfile);

        testMoneyStory.printYears();
        testMoneyStory.printStartAndEnd();
        testMoneyStory.printStartAndEndWithContributions();
        testMoneyStory.printContributions();
        System.out.println(testTimePeriod);
        System.out.println(testReturnRate);
        System.out.println(testContribution);
        System.out.println(testProfile);
        System.out.println(testMoneyStory);
        System.out.println(testMoneyStory.makeContributionArray());
        System.out.println(testMoneyStory.makeReturnArray());

        Year[] testYearArray = testMoneyStory.makeYearArray();

        for (Year year : testYearArray) {
            System.out.println(year);
        } */

    }

}
