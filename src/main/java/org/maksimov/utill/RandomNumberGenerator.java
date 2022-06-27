package org.maksimov.utill;

public class RandomNumberGenerator {
    private int minimumValue;
    private int maximumValue;

    public RandomNumberGenerator() {
    }

    public RandomNumberGenerator(int minimumValue, int maximumValue) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }


    public int randomGenerator() {
        int maximumValue = this.maximumValue;
        int minimumValue = this.minimumValue;
        return (int) ((Math.random() * ((maximumValue - minimumValue) + 1)) + minimumValue);
    }



}
