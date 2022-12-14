package com.holdencasey.investmentcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * A special TimePeriod that includes a return rate for each subdivision of time.
 */
class ReturnRate extends TimePeriod {
    final BigDecimal[] ratesOfReturn; //an array of rates of return in % format (ex: 11.1 being 11.1%)

    /**
     * Main constructor.
     *
     * @param ratesOfReturn an array of rates of return in % format (ex: 11.1 being 11.1%).
     * @param numPeriods the number of unique time periods.
     * @param periodLengths an array of period lengths, in years.
     * @param totalPeriod the total time period.
     */
    ReturnRate(BigDecimal[] ratesOfReturn, int numPeriods, int[] periodLengths, int totalPeriod) {
        super(numPeriods, periodLengths, totalPeriod);
        this.ratesOfReturn = ratesOfReturn;
    }

    /**
     * Constructor if TimePeriod is already created.
     *
     * @param ratesOfReturn an array of rates of return in % format (ex: 11.1 being 11.1%).
     * @param timePeriod the existing TimePeriod object
     */
    ReturnRate(BigDecimal[] ratesOfReturn, TimePeriod timePeriod) {
        super(timePeriod);
        this.ratesOfReturn = ratesOfReturn;
    }

    /**
     * Constructor with only one return rate, and a time period int.
     *
     * @param rateOfReturn the single rate of return.
     * @param timePeriod the single time period as an int.
     */
    ReturnRate(BigDecimal rateOfReturn, int timePeriod) {
        this(new BigDecimal[]{rateOfReturn}, new TimePeriod(timePeriod));
    }

    /**
     * Only return rates array and period lengths array constructor. Calculates the rest.
     *
     * @param ratesOfReturn an array of rates of return in % format (ex: 11.1 being 11.1%).
     * @param periodLengths an array of period lengths, in years.
     */
    ReturnRate(BigDecimal[] ratesOfReturn, int[] periodLengths) {
        this(ratesOfReturn, periodLengths.length, periodLengths, Arrays.stream(periodLengths).sum());
    }

    @Override
    public String toString() {
        return super.toString() + " | Returns: " +
                Arrays.toString(this.ratesOfReturn);
    }
}
