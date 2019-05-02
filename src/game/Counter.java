package game;

/**
 * A base class for MaxCounter
 * This class does all the operations of a Counter object, this includes
 * resetting , increment & decrement and also return the current value of the counter
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
     * decrease the counter value by 1
     */
    public void decrement() {
        value--;
    }

    /**
     * increase the counter value by 1
     */
    public void increment() {
        value++;
    }

    /**
     * Returns the current counter value
     * @return current counter value
     */
    public int getValue() {
        return value;
    }
}
