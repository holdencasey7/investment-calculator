package com.holdencasey;

import java.util.Arrays;

class TimePeriod {
    protected int numPeriods; //the number of unique time periods
    protected int[] periodLengths; //an array of period lengths, in years
    protected int totalPeriod; //the total time period

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
     * Constructor given an existing TimePeriod object.
     *
     * @param timePeriod an existing TimePeriod object.
     */
    TimePeriod(TimePeriod timePeriod) {
        this.numPeriods = timePeriod.numPeriods;
        this.periodLengths = timePeriod.periodLengths;
        this.totalPeriod = timePeriod.totalPeriod;
    }

    //Default constructor for now to avoid errors
    TimePeriod() {}
}
