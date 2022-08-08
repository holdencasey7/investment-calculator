package com.holdencasey;

class Profile {
    private float startingValue;
    private Contribution contributionSystem;
    private ReturnRate returnRate;
    private float endingValue;

    /**
     * Main constructor.
     *
     * @param startingValue the initial investment value.
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     */
    Profile(float startingValue, Contribution contributionSystem, ReturnRate returnRate) {
        this.startingValue = startingValue;
        this.contributionSystem = contributionSystem;
        this.returnRate = returnRate;

        this.endingValue = 0f; //Placeholder
    }

    /**
     * No starting value constructor. Defaults to 0 starting.
     *
     * @param contributionSystem the Contribution system to use.
     * @param returnRate the Return rate system to use.
     */
    Profile(Contribution contributionSystem, ReturnRate returnRate) {
        this(0f, contributionSystem, returnRate);
    }


}
