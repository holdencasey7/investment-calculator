package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        int[] lengths = {4, 2, 1, 3};
        TimePeriod testTimePeriod = new TimePeriod(lengths);

        BigDecimal[] contributions = {new BigDecimal(10.5), new BigDecimal(3),
                new BigDecimal(9), new BigDecimal(11.3)};
        Contribution testContribution = new Contribution(contributions, testTimePeriod);

        BigDecimal[] returns = {new BigDecimal(8), new BigDecimal(6.5),
                new BigDecimal(14), new BigDecimal(6)};
        ReturnRate testReturnRate = new ReturnRate(returns, testTimePeriod);

        Profile testProfile = new Profile(testContribution, testReturnRate);

        MoneyStory testMoneyStory = new MoneyStory(testProfile);

        System.out.println(testMoneyStory.makeContributionArray());
        System.out.println(testMoneyStory.makeReturnArray());

        Year[] testYearArray = testMoneyStory.makeYearArray();

        for (Year year : testYearArray) {
            System.out.println(year);
        }

    }

}
