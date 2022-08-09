package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
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

//        testMoneyStory.printYears();
//        testMoneyStory.printStartAndEnd();
//        testMoneyStory.printStartAndEndWithContributions();
//        testMoneyStory.printContributions();
//        System.out.println(testTimePeriod);
//        System.out.println(testReturnRate);
//        System.out.println(testContribution);
//        System.out.println(testProfile);
//        System.out.println(testMoneyStory);
//        System.out.println(testMoneyStory.makeContributionArray());
//        System.out.println(testMoneyStory.makeReturnArray());
//
//        Year[] testYearArray = testMoneyStory.makeYearArray();
//
//        for (Year year : testYearArray) {
//            System.out.println(year);
//        }

    }

}
