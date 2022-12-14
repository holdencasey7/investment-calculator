package com.holdencasey.investmentcalculator;

import java.util.Arrays;

/**
 * Basic time period data holding class.
 * Can hold an array of different lengths of time.
 */
class TimePeriod {
    final int numPeriods; //the number of unique time periods
    final int[] periodLengths; //an array of period lengths, in years
    final int totalPeriod; //the total time period

    /**
     * Main constructor.
     *
     * @param numPeriods the number of unique time periods.
     * @param periodLengths an array of period lengths, in years.
     * @param totalPeriod the total time period.
     */
    TimePeriod(int numPeriods, int[] periodLengths, int totalPeriod) {
        this.numPeriods = numPeriods;
        this.periodLengths = periodLengths;
        this.totalPeriod = totalPeriod;
    }

    /**
     * Only one period constructor.
     *
     * @param totalPeriod the length of the single time period.
     */
    TimePeriod(int totalPeriod) {
        this(1, new int[]{totalPeriod}, totalPeriod);
    }

    /**
     * No total length constructor. Calculates from array of lengths.
     *
     * @param numPeriods the number of unique time periods.
     * @param periodLengths an array of period lengths, in years.
     */
    TimePeriod(int numPeriods, int[] periodLengths) {
        this(numPeriods, periodLengths, Arrays.stream(periodLengths).sum());
    }

    /**
     * Only period lengths constructor. Calculates the rest.
     *
     * @param periodLengths an array of period lengths, in years.
     */
    TimePeriod(int[] periodLengths) {
        this(periodLengths.length, periodLengths);
    }

    /**
     * Constructor given an existing TimePeriod object.
     *
     * @param timePeriod an existing TimePeriod object.
     */
    TimePeriod(TimePeriod timePeriod) {
        this.numPeriods = timePeriod.numPeriods;
        this.periodLengths = timePeriod.periodLengths;
        this.totalPeriod = timePeriod.totalPeriod;
    }

    @Override
    public String toString() {
        return "Total length: " + this.totalPeriod +
                " years | Periods: " + this.numPeriods +
                " | Lengths: " + Arrays.toString(this.periodLengths);
    }
}
