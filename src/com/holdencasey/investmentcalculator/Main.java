package com.holdencasey.investmentcalculator;

public class Main {
    public static void main(String[] args) {
        int[] lengths = {4, 2, 1, 3};
        TimePeriod testTimePeriod = new TimePeriod(lengths);

        float[] contributions = {10.5f, 3f, 9f, 11.3f};
        Contribution testContribution = new Contribution(contributions, testTimePeriod);

        float[] returns = {8f, 6.5f, 14f, 6f};
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
