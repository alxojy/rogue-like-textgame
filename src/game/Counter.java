package game;

/**
 * This class represents a counter and does the following operations;
 * resetting its value to zero, incrementing its value by 1, decrementing its value by 1
 * and also returning the current value of the counter
 * @author Team Kimchi
 */
public class Counter {

    private int value = 0;

    /**
     * Resets the counter value to 0
     */
    public void reset() {
        value = 0;
    }

    /**
     * Decrease the counter value by 1
     */
    public void decrement() {
        value--;
    }

    /**
     * Increase the counter value by 1
     */
    public void increment() {
        value++;
    }

    /**
     * Returns the current counter value
     *
     * @return int representing the current counter value
     */
    public int getValue() {
        return value;
    }
}
